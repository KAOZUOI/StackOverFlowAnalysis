public class item_frag_adapter extends BaseAdapter {    Context context;    String[] itemname;    int[] image;    LayoutInflater inflater;    public item_frag_adapter(Context context, String[] itemname, int[] image) {        this.context = context;        this.itemname = itemname;        this.image = image;    }    @Override    public int getCount() {        return itemname.length;    }    @Override    public Object getItem(int position) {        return null;    }    @Override    public long getItemId(int position) {        return 0;    }    @Override    public View getView(int position, View convertView, ViewGroup parent) {        if (inflater == null)            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);        if (convertView == null){            convertView = inflater.inflate(R.layout.item_card,null);        }        ImageView imageView = convertView.findViewById(R.id.idIVimage);        TextView textView = convertView.findViewById(R.id.idTVtext);        imageView.setImageResource(image[position]);        textView.setText(itemname[position]);        return convertView;    }}