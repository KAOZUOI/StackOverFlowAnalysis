public class Account {    private final Integer id;    private final String login;    private final Boolean blocked;    public Account(Integer id, String login, Boolean blocked) {        this.id = id;        this.login = login;        this.blocked = blocked;    }    public Integer getId() {        return id;    }    public String getLogin() {        return login;    }    public Boolean getBlocked() {        return blocked;    }}