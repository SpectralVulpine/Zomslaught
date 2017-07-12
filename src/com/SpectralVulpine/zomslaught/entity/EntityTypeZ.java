package com.SpectralVulpine.zomslaught.entity;

import org.bukkit.entity.EntityType;

import net.minecraft.server.v1_12_R1.EntityInsentient;
import net.minecraft.server.v1_12_R1.EntityZombie;
import net.minecraft.server.v1_12_R1.EntityZombieHusk;

public enum EntityTypeZ {
	
	HUSK("Husk", 23, EntityType.HUSK, EntityZombieHusk.class, EntityHuskZ.class),
	ZOMBIE("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, EntityZombieZ.class);
	 
    private String name;
    private int id;
    private EntityType entityType;
    private Class<? extends EntityInsentient> baseClass;
    private Class<? extends EntityInsentient> customClass;
 
    private EntityTypeZ(String name, int id, EntityType entityType,
    		Class<? extends EntityInsentient> baseClass, Class<? extends EntityInsentient> customClass){
        this.name = name;
        this.id = id;
        this.entityType = entityType;
        this.baseClass = baseClass;
        this.customClass = customClass;
    }
 
    public String getName(){
        return this.name;
    }
 
    public int getID(){
        return this.id;
    }
 
    public EntityType getEntityType(){
        return this.entityType;
    }
 
    public Class<? extends EntityInsentient> getNMSClass(){
        return this.baseClass;
    }
 
    public Class<? extends EntityInsentient> getCustomClass(){
        return this.customClass;
    }
    
    /*
    public static void registerEntities(){
        for (EntityTypeZ entity : values()){
            try{
                Method a = EntityTypes.class.getDeclaredMethod("a", new Class<?>[]{Class.class, String.class, int.class});
                a.setAccessible(true);
                a.invoke(null, entity.getCustomClass(), entity.getName(), entity.getID());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
     
        for (BiomeBase biomeBase : BiomeBase.q()){
            if (biomeBase == null){
                break;
            }
         
            for (String field : new String[]{"K", "J", "L", "M"}){
                try{
                    Field list = BiomeBase.class.getDeclaredField(field);
                    list.setAccessible(true);
                    @SuppressWarnings("unchecked")
                    List<BiomeMeta> mobList = (List<BiomeMeta>) list.get(biomeBase);
                 
                    for (BiomeMeta meta : mobList){
                        for (EntityTypeZ entity : values()){
                            if (entity.getNMSClass().equals(meta.b)){
                                meta.b = entity.getCustomClass();
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    */
}
