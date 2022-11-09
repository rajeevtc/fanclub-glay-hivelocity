About the project file
========================

This app is developing using **cocoapods**, so use the `.xcworkspace` file to start development.

## Targets
There are many targets to separate environment, what the app is for.  
Currently the app has two destination to deploy; **Stream Sonic** and **G-Streaming**.  
And there are a few environments like **development**, **In-House distribution**, **production in-house** and **production** for each destination.  
**prouction in-house** should be the same as **production** except for **the name of app and provisioning profile**. But note that `plist` is separated from **production**.

## Custom Flags
Some of the targets have named **"GDS"** and **"PROD"** (currently).  
**"GDS"** indicates if the app is built for GDS project, one of the destination.  
And **"PROD"** indicates if the app is built for production environment.

Destination flags like **"GDS"** is used to switch API information (origin, version , api key, api secret), Apple ID for the app, and [theme](docs/Theme.md) for each destination.  
It is used in `EnvConfigs.swift`. (actually, this file is in a submodule repository)  
See the document about [environment](docs/Environment.md) for more detail.

Environment flags like **"PROD"** is used to determine if analytis service should be enabled or not.  
It is used in `Appdelegate.swift`.

## Release Flow

1. create a release branch `release/*.*.*` when start relasing
   (`*.*.*` will be replaced with actual numbers)
2. version bump and some changes if needed
3. create a tag for RC builds with the format `v*.*.*-rc.*`
4. push tag to remote, it triggers builds on CI
5. send the app to review
6. once the app is released, create a pull request to `master` from release branch
7. merge PR
8. pull master branch to local and create a tag for the release (`v*.*.*`) on the merge commit
9. update changelog by running `npm run changelog`
10. check the diff then commit  
    commit message will be `chore: update changelog for v*.*.*`
11. push master branch and tag to the remote  
    `git push --tags origin master`
12. checkout develop branch
13. merge release branch into `develop` branch
14. push develop branch to remote
15. delete release branch from local if  you want

Documentation
========================
* [BuildTheApp.md](docs/BuildTheApp.md) tells you how to prepeare building the app.
* [Environment.md](docs/Environment.md) to checkout out how to manage files which need to consider about environment.
* [GoogleServices.md](docs/GoogleServices.md) to see what google services are integrated in this app.
* [Acknowledgements.md](docs/Acknowledgements.md) to know what you should do when the plist file for acknowledgements is updated by cocoapds.
* [Theme.md](docs/Theme.md) 
* [Development.md](docs/Development.md) tells you where to modify when changing something.
* [Analytics.md](docs/Analytics.md) tells you about analytics.
* [CountingSongAsPlayed.md](docs/CountingSongAsPlayed.md) covers how the streams is recognized as "played" and
* [CollectingEventLog.md](docs/CollectingEventLog.md) explains when and what this app should send event logs to DWH.
* [ShowingRecommends.md](docs/ShowingRecommends.md) explains where and how to show recommends.
* [ARFeature.md](docs/ARFeature.md) explains about AR feature in this app.
