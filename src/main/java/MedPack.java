import java.util.ArrayList;

public class MedPack
{
    private int packageNum;
    private ArrayList<PackItem> contents;

    private final static ArrayList<PackItem> pack1Items = new ArrayList<PackItem>(){
        {
            //possible pack items with approximate price and weight
            add(new PackItem("Medical Tape", 35.7,2));
            add(new PackItem("Scissors", 0,0));
            add(new PackItem("Tweezers",0,0));
            add(new PackItem("Hydrogen Peroxide",0,0));
            add(new PackItem("Instant Cold Compress",0,0));
            add(new PackItem("Gauze Pads",0,0));
            add(new PackItem("Narcom", 0,0));
            add(new PackItem("Thermal Blanket", 0,0));
            add(new PackItem("Non-Latex Gloves",0,0));
            add(new PackItem("Pain Killer",0,0));
            add(new PackItem("Instructions Manual",0,0));
        }
    };

    private final static ArrayList<PackItem> pack0Items = new ArrayList<PackItem>(){
        {
            add(new PackItem("AED", 0, 0));
            add(new PackItem("EpiPen",0,0));
            add(new PackItem("Inhaler", 0,0));
            add(new PackItem("cprMask",0,0));
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
