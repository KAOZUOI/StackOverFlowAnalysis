<androidx.coordinatorlayout.widget.CoordinatorLayout    android:layout_width=&quot;match_parent&quot;    android:layout_height=&quot;match_parent``your text``&quot;>  <!-- NestedScrollingChild goes here (NestedScrollView, RecyclerView, etc.). -->  <androidx.core.widget.NestedScrollView      android:layout_width=&quot;match_parent&quot;      android:layout_height=&quot;match_parent&quot;      app:layout_behavior=&quot;@string/searchbar_scrolling_view_behavior&quot;>    <!-- Screen content goes here. -->  </androidx.core.widget.NestedScrollView>  <com.google.android.material.appbar.AppBarLayout      android:layout_width=&quot;match_parent&quot;      android:layout_height=&quot;wrap_content&quot;>    <com.google.android.material.search.SearchBar        android:id=&quot;@+id/search_bar&quot;        android:layout_width=&quot;match_parent&quot;        android:layout_height=&quot;wrap_content&quot;        android:hint=&quot;@string/searchbar_hint&quot; />  </com.google.android.material.appbar.AppBarLayout>  <com.google.android.material.search.SearchView      android:layout_width=&quot;match_parent&quot;      android:layout_height=&quot;match_parent&quot;      android:hint=&quot;@string/searchbar_hint&quot;      app:layout_anchor=&quot;@id/search_bar&quot;>    <!-- Search suggestions/results go here (ScrollView, RecyclerView, etc.). -->  </com.google.android.material.search.SearchView></androidx.coordinatorlayout.widget.CoordinatorLayout>