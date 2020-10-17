# Bloc
MVI framework (Jetpack Compose, Coroutines, Dagger, Room, Router, SaveInstanceState, BackPressed)

Bloc is implementation of MVI pattern. Model (Store) contain business logic and emit State then View consume and render State. View emit Intent then Model consume and process Intent.


### Architecture

Single:

<img src="https://github.com/CorvoOrc/Bloc/blob/main/images/BlocArch.png">

Hierarchy:


<img src="https://github.com/CorvoOrc/Bloc/blob/main/images/BlocHierarchy.png">

[Model](https://github.com/CorvoOrc/Bloc/blob/main/bloc/src/main/java/com/example/bloc/store/Store.kt) and [View](https://github.com/CorvoOrc/Bloc/blob/main/bloc/src/main/java/com/example/bloc/view/View.kt) lives inside isolated unit called [Component](https://github.com/CorvoOrc/Bloc/blob/main/bloc/src/main/java/com/example/bloc/component/Component.kt). Component are created by [Assembler](https://github.com/CorvoOrc/Bloc/blob/main/bloc/src/main/java/com/example/bloc/di/ComponentAssembler.kt) and initialized by [InitialValue](https://github.com/CorvoOrc/Bloc/blob/main/bloc/src/main/java/com/example/bloc/value/InitialValue.kt), have own lifecycle and scope for control coroutines. Communication between components do with Input and Output.

View coroutines work on Main dispatcher, Store and Component work on Default dispatcher, Services work on Default and IO dispatchers.

Store emit State reacted on Intent or Effect (ex getting data from database). Effect produce Intent. Store consume Intent and send it to Reducer for processing. As result Reducer generate new State and optional new Label. State used for notify View about changed.

Store and View can communicate with Component - Label used by Store, ViewEvents by View.

[Router](https://github.com/CorvoOrc/Bloc/blob/main/bloc/src/main/java/com/example/bloc/router/Router.kt) control which component active / deactive in current time in same level. It can be on screen level or any another (children router). Also Router participate in BackPressed logic.


### Keywords:

Component - container and communicator for View and Store (Presenter in MVP arch), can be placed in separeted module

Input - pipe for communicate between Components (like Command)

Output - pipe for communicate between Components (like result event)

Description - configuration (contains constants and typed id for factory usage and ability of server rendering)

InitialValue - initial data for Component

Assembler - builder for Component, Store and View, supported binds, provice and factory

State - business data

Intent - View event to Model

Store - Model

View - ui logic

Reducer - Intent handler

Effect - Outer (ex. Service) event to Model

Label - Model event to Component

ViewEvent - View event to Component

Router - activator/deactivator of Component in same level

Interactor - command for business logic for use inside Reducer in complex case

Repository - data logic, convert data from service to business data, can be use directly in Store or in Interactor

Service - logic for receive / send data to outer environment


# Sample

Schema:

<img src="https://github.com/CorvoOrc/Bloc/blob/main/images/WitcherBestiary_Schema.png">

Screenshots:

<img src="https://github.com/CorvoOrc/Bloc/blob/main/images/witcher_bestiary_main_nexus.png" width="300"><img src="https://github.com/CorvoOrc/Bloc/blob/main/images/witcher_bestiary_details_nexus.png" width="300"><img src="https://github.com/CorvoOrc/Bloc/blob/main/images/witcher_bestiary_details_location_nexus.png" width="300">

Bluestack:
<img src="https://github.com/CorvoOrc/Bloc/blob/main/images/witcher_bestiary_main.png">
<img src="https://github.com/CorvoOrc/Bloc/blob/main/images/witcher_bestiary_details.png">

# Inspired by

https://habr.com/en/company/badoo/blog/463781/
