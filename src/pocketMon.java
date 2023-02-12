import java.util.Scanner;

class Pocket {
    static int count = 0;
    String __hidden_owner;
    String[] skills;


    static int counts;  //나중에 핮..

    Pocket(String owner, String skills)
    {
        this.__hidden_owner=owner;
        this.skills = skills.split("/");
        count++;

    }

    public String getOwner() {
        return this.__hidden_owner;
    }

    public void setOwner(String owner) {
        this.__hidden_owner = owner;
    }
    
    public void info() {
        System.out.println(this.__hidden_owner + "의 포켓몬이 가능한 스킬");
        for (int i = 0; i <this.skills.length; i++) {
            System.out.println(i+1 + ":" + this.skills[i]);
        }
    }

    public void attack(int idx) {
        System.out.println(this.skills[idx] + "공격 시전!");
    }

}// end of pocketmon

class Pikachu extends Pocket {
    String name;

    Pikachu(String owner, String skills) {
        super(owner,skills);
        this.name = "피카츄";
        System.out.println(this.name);
    }

    public void attack(int idx) {
        System.out.println("삐카삐카" + this.getOwner() +"의 " + this.name + "가 " + this.skills[idx] + "공격 시전");
    }

}// end of pikachu

class Ggoboogi extends Pocket {
    String name;

    Ggoboogi(String owner, String skills) {
        super(owner,skills);
        this.name = "꼬북이";
        System.out.println(this.name);
    }


    public void attack(int idx) {
        System.out.println("꼬북꼬북" + this.__hidden_owner +"의 "+this.name + "가 " + this.skills[idx] + "공격 시전");
    }

    public void swim() {
        System.out.println(this.name+"가 수영을 합니다.");
    }

}// end of Ggoboogi

class Pairi extends Pocket{
    String name;

    Pairi(String owner, String skills) {
        super(owner,skills);
        this.name = "파이리";
        System.out.println(this.name);
    }

    @Override
    public void attack(int idx) {
        System.out.println("파읠파읠" + this.__hidden_owner +"의 " + this.name + "가 " + this.skills[idx] + "공격 시전");
    }

}// end of pairi


public class pocketMon {
    public static void main(String[] args) {
        Pocket p = null;
    //pocketmon.count
        while (true) {
            System.out.printf("총 %d마리의 포켓몬이 생성되었습니다.\n", Pocket.count);
            Scanner sc = new Scanner(System.in);
            System.out.println("1 : 포켓몬 생성, 2 : 프로그램 종료 :");
            int menu =sc.nextInt();

            if (menu == 2) {
                System.out.println("프로그램을 종료헙나다");
                break;
            }

            else if (menu == 1) {
                System.out.print("1)피카츄 2)꼬북이 3)파이리");
                int pokemon = sc.nextInt();
                sc.nextLine();
                System.out.print("플레이어 이름 입력 : ");
                String n = sc.nextLine();
                System.out.println(("사용 가능한 기술 입력(/로 구분하여 입력) : "));
                String s = sc.nextLine();
                if (pokemon ==1) {
                    p = new Pocket(n,s);
                }//if

                else if (pokemon==2) {
                    p = new Ggoboogi(n,s);

                }// else if

                else if (pokemon ==3) {
                    p = new Pairi(n,s);
                }

                else {
                    System.out.println("메뉴에서 골라 주세요");
                }
//임시로 만듥
                p.info();

                System.out.print("공격 번호 선택");
                int attack_menu = sc.nextInt();
                p.attack(attack_menu-1);


            } //else if

            else {
                System.out.println("메뉴에서 골라주세요");
            }
        } // while
    }
}
