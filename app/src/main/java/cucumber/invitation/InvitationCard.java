package cucumber.invitation;

public class InvitationCard {
  private String name;
  

  private Integer id;

  public InvitationCard(String name, Integer id) {
    this.name = name;
    this.id = id;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }
}
