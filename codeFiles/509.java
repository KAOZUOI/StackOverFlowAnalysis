cartref.addChildEventListener(new ChildEventListener() {            @Override            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {                String cartkey = snapshot.getValue(String.class);                DatabaseReference itemRef = FirebaseDatabase.getInstance().getReference(&quot;User&quot;);                itemRef.addChildEventListener(new ChildEventListener() {                    @Override                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {                        for (DataSnapshot childSnapshot: snapshot.child(&quot;Inventory&quot;).getChildren()) {                            CartInventory inventory = childSnapshot.getValue(CartInventory.class);                            inventory.setKey(childSnapshot.getKey());                            String itemKey = inventory.getKey();                            if(itemKey.equals(cartkey)){                                cartArrayList.add(inventory);                            }                        }                        cartAdapter.notifyDataSetChanged();                    }         // the rest of the childevent listener 