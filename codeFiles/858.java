//Set of categories a user is following    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)     @JoinTable(name = &quot;user_category&quot;,             joinColumns = @JoinColumn(                    name = &quot;user_id&quot;,                                  referencedColumnName = &quot;id&quot;),                      inverseJoinColumns = @JoinColumn(                                    name = &quot;category_id&quot;,                    referencedColumnName = &quot;categoryId&quot;))    private Set<Category> categories=new HashSet<>();