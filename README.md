# react-native-rn-blob-text

## Getting started

`$ npm install react-native-rn-blob-text --save`

### Mostly automatic installation

`$ react-native link react-native-rn-blob-text`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-rn-blob-text` and add `RnBlobText.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRnBlobText.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.rn.blobtext.RnBlobTextPackage;` to the imports at the top of the file
  - Add `new RnBlobTextPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-rn-blob-text'
  	project(':react-native-rn-blob-text').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-rn-blob-text/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-rn-blob-text')
  	```


## Usage
```javascript
import RnBlobText from 'react-native-rn-blob-text';

// TODO: What to do with the module?
RnBlobText;
```
