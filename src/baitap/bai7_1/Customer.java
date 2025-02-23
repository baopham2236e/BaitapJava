package bai7_1;

public class Customer {
    private String name;
    private boolean member;
    private String memberType;

    public Customer(String name) {
        this.name = name;
        this.member = false;
        this.memberType = "None";
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        if (member) {
            this.memberType = memberType;
        } else {
            this.memberType = "None";
        }
    }

    @Override
    public String toString() {
        return String.format("Customer[name=%s, member=%b, memberType=%s]", name, member, memberType);
    }
}
