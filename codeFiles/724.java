<?xml version=&quot;1.0&quot; encoding=&quot;utf-8&quot;?><RelativeLayout xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;    android:layout_width=&quot;match_parent&quot;    android:layout_height=&quot;match_parent&quot;    android:background=&quot;@color/white&quot;>    <LinearLayout        xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;        android:layout_width=&quot;match_parent&quot;        android:layout_height=&quot;match_parent&quot;        android:orientation=&quot;vertical&quot;        android:weightSum=&quot;100&quot;        android:background=&quot;@color/white&quot;>        <androidx.recyclerview.widget.RecyclerView            android:layout_width=&quot;match_parent&quot;            android:layout_height=&quot;0dp&quot;            android:layout_weight=&quot;50&quot;            android:id=&quot;@+id/user_list_recycler_view&quot;>        </androidx.recyclerview.widget.RecyclerView>        <RelativeLayout            android:layout_width=&quot;match_parent&quot;            android:layout_height=&quot;0dp&quot;            android:layout_weight=&quot;50&quot;            android:id=&quot;@+id/map_container&quot;>            <com.google.android.gms.maps.MapView                xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;                android:layout_width=&quot;match_parent&quot;                android:layout_height=&quot;match_parent&quot;                android:id=&quot;@+id/user_list_map&quot;/>        </RelativeLayout>    </LinearLayout>    <ProgressBar        android:layout_width=&quot;wrap_content&quot;        android:layout_height=&quot;wrap_content&quot;        android:id=&quot;@+id/progressBar&quot;        android:layout_centerInParent=&quot;true&quot;        android:visibility=&quot;gone&quot;/></RelativeLayout>