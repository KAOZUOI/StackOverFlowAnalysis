package com.portfolio.todoapp.asoviewtodo.Service;import com.portfolio.todoapp.asoviewtodo.Repositopry.UserRepository;import com.portfolio.todoapp.asoviewtodo.UserDetailsImpl;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.security.core.GrantedAuthority;import org.springframework.security.core.authority.SimpleGrantedAuthority;import org.springframework.security.core.userdetails.UserDetails;import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.core.userdetails.UsernameNotFoundException;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import java.util.*;@Servicepublic class UserDetailsServiceImpl implements UserDetailsService {    @Autowired    PasswordEncoder passwordEncoder;    @Autowired    JdbcTemplate jdbcTemplate;    @Autowired    UserRepository userRepository;    @Override    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {        try {            String sql = &quot;SELECT * FROM asoviewtodo.users WHERE email = ?;&quot;;`your text`            Map<String, Object> map = jdbcTemplate.queryForMap(sql, email);            String password = (String)map.get(&quot;password&quot;);            Collection<GrantedAuthority> authorities = new ArrayList<>();            authorities.add(new SimpleGrantedAuthority((String)map.get(&quot;authority&quot;)));            return new UserDetailsImpl(email, password, authorities);        }catch (Exception e) {            throw new UsernameNotFoundException(&quot;user not found&quot;, e);        }    }    @Transactional    public void register(String email, String password, String authority) {        String sql = &quot;INSERT INTO asoviewtodo.users (email, password, authority) VALUES (?,?,?)&quot;;        jdbcTemplate.update(sql, email, passwordEncoder.encode(password), authority);    }}