package by.tms.lesson30_31_design_patterns_gof.behavioral.template_method;

public abstract class CaffeineBeverageWithHook {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
    public abstract void brew();
    public abstract void addCondiments();
    public void boilWater() {
        System.out.println("Boiling water");
    }
    public void pourInCup() {
        System.out.println("Pouring into cup");
    }
    public boolean customerWantsCondiments() {
        return true;
    }
}
