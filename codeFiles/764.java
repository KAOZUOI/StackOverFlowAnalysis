<?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?><manifest xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;    xmlns:tools=&quot;http://schemas.android.com/tools&quot;>    <uses-permission android:name=&quot;android.permission.READ_EXTERNAL_STORAGE&quot;/>    <application        android:allowBackup=&quot;true&quot;        android:dataExtractionRules=&quot;@xml/data_extraction_rules&quot;        android:fullBackupContent=&quot;@xml/backup_rules&quot;        android:icon=&quot;@mipmap/ic_launcher&quot;        android:label=&quot;@string/app_name&quot;        android:preserveLegacyExternalStorage=&quot;true&quot;        android:roundIcon=&quot;@mipmap/ic_launcher_round&quot;        android:supportsRtl=&quot;true&quot;        android:theme=&quot;@style/Theme.NoteApp&quot;        tools:targetApi=&quot;31&quot;>        <activity            android:name=&quot;.activities.CreateNoteActivity&quot;            android:screenOrientation=&quot;portrait&quot;            android:windowSoftInputMode=&quot;stateHidden&quot;            android:exported=&quot;false&quot;>            <meta-data                android:name=&quot;android.app.lib_name&quot;                android:value=&quot;&quot; />        </activity>        <activity            android:name=&quot;.activities.MainActivity&quot;            android:screenOrientation=&quot;portrait&quot;            android:windowSoftInputMode=&quot;stateHidden&quot;            android:exported=&quot;true&quot;            android:label=&quot;@string/app_name&quot;            android:theme=&quot;@style/Theme.NoteApp.NoActionBar&quot;>            <intent-filter>                <action android:name=&quot;android.intent.action.MAIN&quot; />                <category android:name=&quot;android.intent.category.LAUNCHER&quot; />            </intent-filter>            <meta-data                android:name=&quot;android.app.lib_name&quot;                android:value=&quot;&quot; />        </activity>    </application></manifest>