    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_create_note);        ImageView imageBack = findViewById(R.id.imageBack);        imageBack.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View view) {                onBackPressed();            }        });        inputNoteTitle = findViewById(R.id.inputNoteTitle);        inputNoteText = findViewById(R.id.inputNote);        textDateTime = findViewById(R.id.textDateTime);        imageNote = findViewById(R.id.imageNote);        textDateTime.setText(                new SimpleDateFormat(&quot;EEEE, dd MMMM yyyy HH:mm a&quot;, Locale.getDefault())                        .format(new Date())        );        ImageView imageSave = findViewById(R.id.imageSave);        imageSave.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                saveNote();            }        });        ImageView imageAddImage = findViewById(R.id.imageAddImage);        imageAddImage.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View v) {                int requestPermission = ContextCompat.checkSelfPermission(                        getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE                );                if (requestPermission != PackageManager.PERMISSION_GRANTED){                    ActivityCompat.requestPermissions(                            CreateNoteActivity.this,                            new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},                            REQUEST_CODE_STORAGE_PERMISSION                    );                }                else {                    selectImage();                }            }        });    } @Override    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {        super.onRequestPermissionsResult(requestCode, permissions, grantResults);        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION && grantResults.length > 0){            Log.d(&quot;DEBUG&quot;, &quot;&quot; + grantResults[0]);            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){                selectImage();            }            else {                Toast.makeText(this, &quot;Permission Denied!&quot;, Toast.LENGTH_SHORT).show();            }        }    }