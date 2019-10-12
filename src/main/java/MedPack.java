import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MedPack
{
    private int packageNum;
    private ArrayList<PackItem> contents;

    private final static ArrayList<PackItem> pack1Items = new ArrayList<PackItem>(){
        {
            //possible pack items with approximate price and weight
            add(new PackItem("Medical Tape", 35.7,2));
            PackItem scissors = new PackItem("Scissors", 0,0);
            PackItem tweezers = new PackItem("Tweezers",0,0);
            PackItem hydroPerox = new PackItem("Hydrogen Peroxide",0,0);
            PackItem coldComp = new PackItem("Instant Cold Compress",0,0);
            PackItem gauze = new PackItem("Gauze Pads",0,0);
            PackItem adhesiveBandages = new PackItem("Adhesive Bandages", 0,0);
            PackItem blanket = new PackItem("Thermal Blanket", 0,0);
            PackItem gloves = new PackItem("Non-Latex Gloves",0,0);
        }

    };

    private final static ArrayList<PackItem> pack0Items = new ArrayList<PackItem>(){
        {
            PackItem aed = new PackItem("AED", 0, 0);
            PackItem epipen = new PackItem("EpiPen",0,0);
            PackItem inhaler = new PackItem("Inhaler", 0,0);
            PackItem cprMask = new PackItem("cprMask",0,0);
        }
    };

    public MedPack()
    {
        packageNum = 0;
        contents.addAll(pack0Items);
        contents.addAll(pack1Items);
    }

    public MedPack(int packageNum)
    {
        this.packageNum = packageNum;
        contents = new ArrayList<PackItem>();
        switch (packageNum)
        {
            case 0:
                contents.addAll(pack0Items);
            case 1:
                contents.addAll(pack1Items);
                break;
            default:
                contents.addAll(pack0Items);
                contents.addAll(pack1Items);
                break;
        }
    }

    public int getPackageNum() {
        return packageNum;
    }
}
