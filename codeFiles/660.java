package com.webprojekt.webblog.DAO;import jakarta.persistence.*;import jakarta.validation.constraints.NotEmpty;import jakarta.validation.constraints.Pattern;import jakarta.validation.constraints.Size;import lombok.AllArgsConstructor;import lombok.Builder;import lombok.Data;import lombok.NoArgsConstructor;import java.util.List;@Data@Entity(name = &quot;user&quot;)@Table@Builder@AllArgsConstructor@NoArgsConstructorpublic class User {    @Id    @SequenceGenerator(            name = &quot;user_sequence&quot;,            sequenceName = &quot;user_sequence&quot;,            allocationSize = 1    )    @GeneratedValue(            strategy = GenerationType.SEQUENCE,            generator = &quot;user_sequence&quot;    )    @Column(            nullable = false    )    private long id;    @Column(            name = &quot;name&quot;,            nullable = true,            columnDefinition = &quot;TEXT&quot;    )    private String name;    @Column(            name = &quot;is_user_admin&quot;    )    boolean isAdmin;    @Column(            name = &quot;username&quot;    )    @NotEmpty    @Pattern(regexp = &quot;^[a-zA-Z0-9_]+$&quot;, message = &quot;Only letters, digits and underscores allowed&quot;)    private String username;    @Column(       name =&quot;password&quot;    )    @Size(min = 5, message = &quot;your password must have at least 5 characters&quot;)    private String password;    @Transient    private String password2;    @OneToMany(mappedBy = &quot;user&quot;)    private List<Entry> entry;    @OneToMany(mappedBy = &quot;user&quot;)    private List<Comment> comment;    public User(String name) {        this.name = name;        this.isAdmin=false;    }//DTO Login    public User(String username, String password1) {        this.username = username;        this.password = password1;    }//DTO registration    public User( String username, String password1, String password2) {        this.username = username;        this.password = password1;        this.password2 = password2;    }    public User(String name, String username, String password, String password2) {        this.name = name;        this.username = username;        this.password = password;        this.password2 = password2;    }}