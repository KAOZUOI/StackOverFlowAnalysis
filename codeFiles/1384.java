<?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?><androidx.constraintlayout.widget.ConstraintLayout    xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;    android:layout_width=&quot;match_parent&quot;    android:layout_height=&quot;match_parent&quot;    xmlns:app=&quot;http://schemas.android.com/apk/res-auto&quot;>    <ScrollView        android:id=&quot;@+id/pane1&quot;        android:layout_width=&quot;match_parent&quot;        android:layout_height=&quot;0dp&quot;        app:layout_constraintTop_toTopOf=&quot;parent&quot;        app:layout_constraintBottom_toTopOf=&quot;@id/pane2&quot;        app:layout_constraintStart_toStartOf=&quot;parent&quot;        app:layout_constraintEnd_toEndOf=&quot;parent&quot;>        <LinearLayout            android:layout_width=&quot;match_parent&quot;            android:layout_height=&quot;wrap_content&quot;            android:orientation=&quot;vertical&quot;            android:gravity=&quot;top&quot;>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>            <TextView                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;                android:text=&quot;Enter something:&quot;/>            <EditText android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;wrap_content&quot;/>        </LinearLayout>    </ScrollView>    <LinearLayout        android:id=&quot;@+id/pane2&quot;        android:layout_width=&quot;match_parent&quot;        android:layout_height=&quot;wrap_content&quot;        android:orientation=&quot;vertical&quot;        app:layout_constraintTop_toBottomOf=&quot;@id/pane1&quot;        app:layout_constraintBottom_toBottomOf=&quot;parent&quot;        app:layout_constraintStart_toStartOf=&quot;parent&quot;        app:layout_constraintEnd_toEndOf=&quot;parent&quot;>        <Button android:layout_width=&quot;match_parent&quot;            android:layout_height=&quot;wrap_content&quot;            android:text=&quot;SUBMIT&quot;/>    </LinearLayout></androidx.constraintlayout.widget.ConstraintLayout>