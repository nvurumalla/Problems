import java.util.*;

public class SoftwareDependenies {
    public static class Component {
        private String name;
        private int n;
        private List<Component> dependencyList;

        public Component(String name) {
            this.name = name;
            this.dependencyList = new ArrayList<>();
        }

        public String getName() {
            return this.name;
        }

        public List<Component> getDependencies() {
            return this.dependencyList;
        }

        public void addDependency(Component dependency) {
            this.dependencyList.add(dependency);
        }

        // Overriding hash and equals so as to use list.contains
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            else if ((o instanceof Component) && (((Component) o).getName().equals(this.name))) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    // Maintains entire list of installed components
    private static List<Component> installedCompList = new ArrayList<>();
    // Maintains map of all component name to component instances
    private static HashMap<String, Component> compMap = new HashMap<>();
    private static List<Component> explicitlyInstalled = new ArrayList<>();


    /*
     * Complete the function below.
     */
    static void doIt(String[] input) {
        Component[] installedCompList = new Component[10];
        Arrays.sort(installedCompList, ((o1, o2) -> o1.n-o2.n));
        for (String in : input) {
            System.out.println(in);
            String[] compList = in.split("\\s+");
            String command = compList[0];

            switch (command) {
                case "DEPEND" :
                    buildComponentDependencies(compList[1], compList);
                    break;
                case "INSTALL":
                    explicitlyInstalled.add(getComponent(compList[1]));
                    installComponent(compList[1]);
                    break;
                case "REMOVE":
                    explicitlyInstalled.remove(getComponent(compList[1]));
                    removeComponent(compList[1]);
                    break;
                case "LIST":
                    for (Component component : installedCompList) {
                        System.out.println(component.getName());
                    }
                    break;
                case "END":
                    break;
            }
        }

    }

    private static Component getComponent(String name) {
        Component comp = compMap.get(name);
        if (null == comp) {
            comp = new Component(name);
            compMap.put(name, comp);
        }
        return comp;
    }

    private static boolean isAlreadyInstalled(Component component) {
        return installedCompList.contains(component);
    }

    private static void installComponent(String compName) {
        Component component = getComponent(compName);
        if (isAlreadyInstalled(component)) {
            System.out.println(compName + " is already installed");
        } else {
            // Installing dependencies first, if not installed
            for (Component compDependency : component.getDependencies()) {
                if (!isAlreadyInstalled(compDependency)) {
                    installComponent(compDependency.getName());
                }
            }
            System.out.println("Installing " + component.getName());
            installedCompList.add(component);
        }
    }

    private static void buildComponentDependencies(String compName, String[] compList) {
        Component component = getComponent(compName);
        // Dependency list starts from the 3rd word of the input line
        for (int i = 2; i < compList.length; i++) {
            String dependency = compList[i];

            // Check if the dependency is already dependent on current component
            List<Component> internalDependencies = getComponent(dependency).getDependencies();
            if (null != internalDependencies && internalDependencies.contains(component)) {
                System.out.println(dependency + " depends on " + compName + ", ignoring command");
            } else if (component.getDependencies().contains(getComponent(dependency))) {
                // Check if the dependency is already present in the list of dependencies
                System.out.println(dependency + " is already a dependency of " + compName + ", ignoring command");
            } else {
                component.addDependency(getComponent(dependency));
            }
        }
    }

    private static void removeComponent(String compName) {
        Component component = getComponent(compName);
        if (!isAlreadyInstalled(component)) {
            System.out.println(compName + " is not installed");
        } else if (isComponentRemovable(component)) {
            System.out.println("Removing " + compName);
            installedCompList.remove(component);

            // Remove the dependencies that are not no longer needed to support another component
            for (Component dependencyComp : component.getDependencies()) {
                if (isComponentRemovable(dependencyComp) && !explicitlyInstalled.contains(dependencyComp)) {
                    removeComponent(dependencyComp.getName());
                }
            }
        } else {
            System.out.println(compName + " is still needed");
        }
    }

    private static boolean isComponentRemovable(Component component) {
        // Check for the component in all installed component dependencies
        for (Component installedComponent : installedCompList) {
            if (null != installedComponent.getDependencies() &&
                    installedComponent.getDependencies().contains(component)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] input = new String[] {
                "DEPEND TELNET TCPIP NETCARD",
                "DEPEND TCPIP NETCARD",
                "DEPEND NETCARD TCPIP",
                "DEPEND DNS TCPIP NETCARD",
                "DEPEND BROWSER TCPIP HTML",
                "INSTALL NETCARD",
                "INSTALL TELNET",
                "INSTALL foo",
                "REMOVE NETCARD",
                "INSTALL BROWSER",
                "INSTALL DNS",
                "LIST",
                "REMOVE TELNET",
                "REMOVE NETCARD",
                "REMOVE DNS",
                "REMOVE NETCARD",
                "INSTALL NETCARD",
                "REMOVE TCPIP",
                "REMOVE BROWSER",
                "REMOVE TCPIP",
                "LIST",
                "END"};

        doIt(input);

    }
}
