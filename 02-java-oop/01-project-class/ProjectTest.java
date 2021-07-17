public class ProjectTest{
    public static void main(String[] args){
        Project p = new Project();
        p.setName("First OOP Project");
        p.setDescription("My first project is somewhat understandable");
        String projectName = p.getName();
        String projectDescription = p.getDescription();

        System.out.println("This is my " + projectName, ", and " + projectDescription);
    }
}