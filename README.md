![FenKolo](https://github.com/alouanemed/FenKolo/blob/master/app/src/main/ic_launcher-web.png?raw=true)

(work-in-progress 👷🔧️👷‍♀️⛏)

Get closest restaurnet and snacks sorted by type and curated using tips shared by people.

## Android development

 * Written in Java. one of the Udacity requirements.
 * Uses [RxJava](https://github.com/ReactiveX/RxJava) 2
 * Uses all of the [Architecture Components](https://developer.android.com/topic/libraries/architecture/): Room, LiveData and Lifecycle-components
 * Uses [dagger-android](https://google.github.io/dagger/android.html) for dependency injection

## Development setup

First off, you require the latest Android Studio 3.0 (or newer) to be able to build the app.


### API keys

The app uses data from Frousquare. Create a developer account [Here](https://foursquare.com/developers/signup) 


When you obtain the keys, you can provide them to the app by putting the following in the
`gradle.properties` file inside `data` module:

```
# Get these from Frousquare
clientId=<insert>
clientSecret=<insert>
apiVersion=<insert>
```


## Contributions

If you've found an error in this sample, please file an issue.

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request. Since this project is still in its very early stages,
if your change is substantial, please raise an issue first to discuss it.

Art done by YVW .

## License

```
Copyright 2018 Mohamed Alouane.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```
