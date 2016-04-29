package net.minecraft.util.datafix.fixes;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

public class MinecartEntityTypes implements IFixableData
{
    private static final List<String> field_188222_a = Lists.newArrayList(new String[] {"MinecartRideable", "MinecartChest", "MinecartFurnace", "MinecartTNT", "MinecartSpawner", "MinecartHopper", "MinecartCommandBlock"});

    public int getFixVersion()
    {
        return 106;
    }

    public NBTTagCompound fixTagCompound(NBTTagCompound compound)
    {
        if ("Minecart".equals(compound.getString("id")))
        {
            String s = "MinecartRideable";
            int i = compound.getInteger("Type");

            if (i > 0 && i < field_188222_a.size())
            {
                s = (String)field_188222_a.get(i);
            }

            compound.setString("id", s);
            compound.removeTag("Type");
        }

        return compound;
    }
}