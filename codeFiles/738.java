package com.example.myapplication;import android.app.Activity;import android.app.ActivityManager;import android.app.ActivityOptions;import android.app.admin.DevicePolicyManager;import android.content.ComponentName;import android.content.Context;import android.content.Intent;import android.content.pm.PackageManager;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.Button;import android.widget.TextView;import androidx.activity.result.ActivityResult;import androidx.activity.result.ActivityResultCallback;import androidx.activity.result.ActivityResultLauncher;import androidx.activity.result.contract.ActivityResultContracts;import androidx.appcompat.app.AppCompatActivity;import androidx.navigation.NavController;import androidx.navigation.Navigation;import androidx.navigation.ui.AppBarConfiguration;import androidx.navigation.ui.NavigationUI;import com.example.myapplication.databinding.ActivityMainBinding;import android.view.Menu;import android.view.MenuItem;import android.widget.Toast;import com.example.myapplication.helper.MqttHelper;import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;import org.eclipse.paho.client.mqttv3.MqttMessage;public class MainActivity extends AppCompatActivity implements View.OnClickListener{    private Button lock, disable, enable;    private static final int RESULT_ENABLE = 11;    private DevicePolicyManager devicePolicyManager;    private ActivityManager activityManager;    private ComponentName componentName;    private AppBarConfiguration appBarConfiguration;    private ActivityMainBinding binding;    MqttHelper mqttHelper;    //ChartHelper mChart;    //LineChart chart;    TextView dataReceived;    private Button btnPublish;    // Allowlist two apps.    private static final String KIOSK_PACKAGE = &quot;com.example.myapplication&quot;;    private static final String[] APP_PACKAGES = {KIOSK_PACKAGE};// ...    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        binding = ActivityMainBinding.inflate(getLayoutInflater());        setContentView(binding.getRoot());        //setContentView(R.layout.activity_main);        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);        componentName = new ComponentName(this, Controller.class);        lock = (Button) findViewById(R.id.lock);        enable = (Button) findViewById(R.id.enable);        disable = (Button) findViewById(R.id.disable);        lock.setOnClickListener(this);        enable.setOnClickListener(this);        disable.setOnClickListener(this);                       dataReceived = (TextView) findViewById(R.id.textview_first);        startMqtt();    }    @Override    protected void onResume() {        super.onResume();        boolean isActive = devicePolicyManager.isAdminActive(componentName);    }    @Override    public void onClick(View view) {        if (view == lock) {            boolean active = devicePolicyManager.isAdminActive(componentName);            if(active) {                devicePolicyManager.lockNow();            } else {                Toast.makeText(this, &quot;You need to enable the Admin Device Features&quot;, Toast.LENGTH_SHORT).show();            }        } else if (view == enable) {            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,&quot;You Should Enable the app!&quot;);            //someActivityResultLauncher.launch(intent);            // Caller            mGetContent.launch(intent);            // Receiver            //startActivityForResult(intent, RESULT_ENABLE);        } else if (view == disable) {            devicePolicyManager.removeActiveAdmin(componentName);            disable.setVisibility(View.GONE);            enable.setVisibility(View.VISIBLE);        }    }    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(            new ActivityResultContracts.StartActivityForResult(),            new ActivityResultCallback<ActivityResult>() {                @Override                public void onActivityResult(ActivityResult result) {                    if (result.getResultCode() == Activity.RESULT_OK) {                        // Here, no request code                        Intent data = result.getData();                        Toast.makeText(MainActivity.this, &quot;enabled&quot;, Toast.LENGTH_SHORT).show();                    }else{                        Toast.makeText(MainActivity.this, &quot;Failed&quot;, Toast.LENGTH_SHORT).show();                    }                }            });    @Override    protected void onActivityResult(int requestCode, int resultCode, Intent data) {                if(resultCode== Activity.RESULT_OK  && requestCode == RESULT_ENABLE){                    Toast.makeText(MainActivity.this, &quot;enabled&quot;, Toast.LENGTH_SHORT).show();                }else {                    Toast.makeText(MainActivity.this, &quot;Failed&quot;, Toast.LENGTH_SHORT).show();                }        super.onActivityResult(requestCode, resultCode, data);    }    /*@Override    protected void onActivityResult(int requestCode, int resultCode, Intent data) {        switch (requestCode){            case RESULT_ENABLE:                if(resultCode== Activity.RESULT_OK ){                    //btn_unblock.setText(&quot;Dissable&quot;);                    //btn_block.setVisibility(View.VISIBLE);                    Toast.makeText(MainActivity.this, &quot;enabled&quot;, Toast.LENGTH_SHORT).show();                }else{                    Toast.makeText(MainActivity.this, &quot;Failed&quot;, Toast.LENGTH_SHORT).show();                }                break;        }        super.onActivityResult(requestCode, resultCode, data);    }*/    @Override    public boolean onCreateOptionsMenu(Menu menu) {        // Inflate the menu; this adds items to the action bar if it is present.        getMenuInflater().inflate(R.menu.menu_main, menu);        return true;    }    @Override    public boolean onOptionsItemSelected(MenuItem item) {        // Handle action bar item clicks here. The action bar will        // automatically handle clicks on the Home/Up button, so long        // as you specify a parent activity in AndroidManifest.xml.        int id = item.getItemId();        //noinspection SimplifiableIfStatement        if (id == R.id.action_settings) {            return true;        }        return super.onOptionsItemSelected(item);    }    @Override    public boolean onSupportNavigateUp() {        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);        return NavigationUI.navigateUp(navController, appBarConfiguration)                || super.onSupportNavigateUp();    }    // MQTT Code    private void startMqtt(){        mqttHelper = new MqttHelper(getApplicationContext());        mqttHelper.mqttAndroidClient.setCallback(new MqttCallbackExtended() {            @Override            public void connectComplete(boolean b, String s) {                Log.w(&quot;Debug&quot;,&quot;Connected&quot;);            }            @Override            public void connectionLost(Throwable throwable) {            }            @Override            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {                Log.w(&quot;Debug&quot;,mqttMessage.toString());                dataReceived.setText(mqttMessage.toString());                //mChart.addEntry(Float.valueOf(mqttMessage.toString()));            }            @Override            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {            }        });    }}