package exceptionDemo;

public class CustomException {
    public static void main(String[] args) {
        CustomException customException=new CustomException();
        try{
            System.out.println("execution starts");
            System.out.println(customException.validate("",2));
        }
        catch (NameException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("some error occurred");
        }
        System.out.println("execution ends");


    }
    public String validate(String name,int id) throws NameException{
        if(name.length()==0){
            throw new NameException("name is null,kindly provide the valid name");
        }
        return "User name is "+name+" and Id is "+id;
    }
}
