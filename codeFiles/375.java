record Data (int id, int score) {  @Override  public String toString() {      return&quot;id=%d, score=%d&quot;.formatted(id, score);  }}String data = &quot;1 456 2 100 3 600 1 400&quot;;