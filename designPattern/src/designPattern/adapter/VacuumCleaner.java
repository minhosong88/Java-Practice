package designPattern.adapter;

public class VacuumCleaner implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("청소기 220V On");

    }
}
