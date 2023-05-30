protected void onCreate(Bundle savedInstanceState) {    super.onCreate(savedInstanceState);    setContentView(R.layout.activity_main);    // check for runtime permissions    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED) {            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.SEND_SMS, Manifest.permission.READ_CONTACTS}, 100);        }    }    // this is a special permission required only by devices using    // Android Q and above. The Access Background Permission is responsible    // for populating the dialog with &quot;ALLOW ALL THE TIME&quot; option    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {        requestPermissions(new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION}, 100);    }    button1 = findViewById(R.id.Button1);    listView = (ListView) findViewById(R.id.ListView);    db = new DbHelper(this);    list = db.getAllContacts();    customAdapter = new CustomAdapter(this, list);    listView.setAdapter(customAdapter);    send = findViewById(R.id.send);    button1.setOnClickListener(new View.OnClickListener() {        @Override        public void onClick(View v) {            // calling of getContacts()            if (db.count() != 5) {                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);                startActivityForResult(intent, PICK_CONTACT);            } else {                Toast.makeText(MainActivity.this, &quot;Can't Add more than 5 Contacts&quot;, Toast.LENGTH_SHORT).show();            }        }    });    send.setOnClickListener(new View.OnClickListener() {        @Override        public void onClick(View v) {            Location object = new Location(&quot;service Provider&quot;);            double lat = object.getLatitude(); double lng = object.getLongitude();            onSuccess(object);        }    });}public void onSuccess(Location currentLocation) {    String uri = &quot;http://maps.google.com/maps?saddr=&quot; + currentLocation.getLatitude()+&quot;,&quot;+currentLocation.getLongitude();    StringBuffer smsBody = new StringBuffer();    smsBody.append(Uri.parse(uri));        // get the SMSManager        SmsManager smsManager = SmsManager.getDefault();        // get the list of all the contacts in Database        DbHelper db = new DbHelper(MainActivity.this);        List<ContactModel> list = db.getAllContacts();        // send SMS to each contact        for (ContactModel c : list) {            String message = &quot;Hey, &quot; + c.getName() + &quot;I am in DANGER, i need help. Please urgently reach me out. Here are my coordinates.\n &quot; + uri;            smsManager.sendTextMessage(c.getPhoneNo(), null, message, null, null);        }}@Overridepublic void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {    super.onRequestPermissionsResult(requestCode, permissions, grantResults);    if (requestCode == 100) {        if (grantResults[0] == PackageManager.PERMISSION_DENIED) {            Toast.makeText(this, &quot;Permissions Denied!\n Can't use the App!&quot;, Toast.LENGTH_SHORT).show();        }    }}@Overrideprotected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {    super.onActivityResult(requestCode, resultCode, data);    // get the contact from the PhoneBook of device    switch (requestCode) {        case (PICK_CONTACT):            if (resultCode == Activity.RESULT_OK) {                Uri contactData = data.getData();                Cursor c = managedQuery(contactData, null, null, null, null);                if (c.moveToFirst()) {                    String id = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));                    String hasPhone = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));                    String phone = null;                    try {                        if (hasPhone.equalsIgnoreCase(&quot;1&quot;)) {                            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + &quot; = &quot; + id, null, null);                            phones.moveToFirst();                            phone = phones.getString(phones.getColumnIndex(&quot;data1&quot;));                        }                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));                        db.addcontact(new ContactModel(0, name, phone));                        list = db.getAllContacts();                        customAdapter.refresh(list);                    } catch (Exception ex) {                    }                }            }            break;    }}