## Adding the YunoAntiFraud ClearSale library to the project
Add the YunoAntiFraud ClearSale dependency to the application build.gradle file:

```Gradle 
dependencies {
    implementation 'com.yuno.fraud-prevention:clearsale:{last_version}'
}
```
#### Permissions
We include the INTERNET permission by default as ClearSale needs them,

```xml 
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <uses-permission android:name="android.permission.INTERNET"/>
```
## Optional
If you want to include location data, you must add the location's permissions on your Manifest file:
```xml 
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
```
And you must add the location dependencies on your app's Build.gradle:
```Gradle 
dependencies {
    implementation 'com.google.android.gms:play-services-location:17.0.0'
}
```

### Initialize YunoAntiFraud
First, you'll need to get your ClearSale app key, Then, initialize the library calling the following in the onCreate() method of your application class:
```Kotlin 
initYunoClearSale("Your ClearSale app key")
```

**Note:** If you don't currently implement a custom application, you’ll need to create one. A custom application looks like this:
```kotlin 
class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initYunoClearSale("Your ClearSale app key")
    }
}
```

You’ll need to update your manifest to use your application:
```XML 
<application
    android:name=".CustomApplication">
</application>
```

## Functions
### onCreateYunoClearSale()
You must call onCreateYunoClearSale() method, this depends on the type of screen to be used:
-If it is an Activity screen, onCreateYunoClearSale() must be called at the onCreate().
-If it is a Fragment screen, onCreateYunoClearSale() must be called at the onCreateView().

Activity:
```Kotlin 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateYunoClearSale()
    }
```

Fragment:
```Kotlin 
    override fun onCreateView(
        LayoutInflater inflater, 
        ViewGroup container,
        Bundle savedInstanceState
    ) : View {
        val view = inflater.inflate(layout,container,attachToRoot)
        this.context?.onCreateYunoClearSale()
        return view
    }
```

### onResumeYunoClearSale()
To start the collection of data on the device and screen, call the following method from your activity's or fragment's onResume() method:
```Kotlin 
    onResumeYunoClearSale(
        hasToCollectDeviceInfo : Boolean //set true if you want to collect the device information, set false if you only want to collect screen information
    ) : String //This method returns the sessionId that you will send to Yuno Payments SDK
```
**Note:** If the library is not initialized before call onResumeYunoClearSale() method, you will see a Log like this:
```
    E/YunoClearSale: Attempt to invoke virtual method 'void sale.clear.behavior.android.Behavior.start()' on a null object reference
```
This is because you did not call onCreateYunoClearSale() method at onCreate() method of your screen.

### onStopYunoClearSale()
To stop the collection of data on the device and screen, call the following method from your activity's or fragment's onStop() method:
```Kotlin 
    onStopYunoClearSale()
```
**Note:** If the library is not initialized before call onStopYunoClearSale() method, you will see a Log like this:
```
    E/YunoClearSale: Attempt to invoke virtual method 'void sale.clear.behavior.android.Behavior.stop()' on a null object reference
```
This is because you did not call onCreateYunoClearSale() method at onCreate() method of your screen.