package org.pdfsam.module;

public class ModuleDescriptorBuilderPriority {
	private int priority = ModulePriority.DEFAULT.getPriority();
	
    public ModuleDescriptorBuilder priority(int priority, ModuleDescriptorBuilder Mdbobject) {
        this.priority = priority;
        return Mdbobject;
    }

    public ModuleDescriptorBuilder priority(ModulePriority priority,ModuleDescriptorBuilder Mdbobject ) {
        this.priority = priority.getPriority();
        return Mdbobject;
    }
    
    public int getPriority()
    {
    	return priority;
    }
}
