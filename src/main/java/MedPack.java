/*
 * Name: Addison Armstrong, Kayla Felderman, Nate Unruh, Ram Sajja
 * Name of Project: First Aid in Flight
 * Name of Class: MedPack
 * Description of Class: This Class creates all items needed in the Medpacks. Makes the MedPacks too
 */

// Importing Java Class ArrayList
import java.util.ArrayList;

// Creating MedPack Class
/** This Class creates all items needed in the Medpacks. Makes the MedPacks too */
public class MedPack
{
    // Private Variables
    private int packageNum;
    private ArrayList<PackItem> contents;

    // Creating MedPack 1
    private final static ArrayList<PackItem> pack1Items = new ArrayList<PackItem>(){
        {
            //possible pack items with approximate price and weight
            add(new PackItem("Medical Tape", 11.3398,1)); // https://www.amazon.com/Transpore-Surgical-Medical-First-Aid-Non-Sterile/dp/B01J44DV9O/ref=sr_1_4?keywords=small+Medical+tape&qid=1570929513&sr=8-4
            add(new PackItem("Scissors", 27.2155,4)); // https://www.amazon.com/PhysiciansCare-First-Aid-Only-90294/dp/B007D7ZU3A/ref=sr_1_3?keywords=small+medical+Scissors&qid=1570929075&sr=8-3
            add(new PackItem("Tweezers",37.798,1)); // https://www.amazon.com/SE-365PT12-Assorted-Lightweight-Tweezers/dp/B073S6V3ZP/ref=sr_1_7?keywords=small+plastic+tweezers&qid=1570929466&sr=8-7
            add(new PackItem("Hydrogen Peroxide",75.126,5)); // https://www.amazon.com/Hydrogen-Peroxide-Travel-Spray-Pack/dp/B07FM7X2KX/ref=sr_1_6?crid=292TD7Y5TJJ9E&keywords=small+hydrogen+peroxide+bottle&qid=1570929326&sprefix=Small+hydrogen%2Caps%2C166&sr=8-6
            add(new PackItem("Instant Cold Compress",120.97,2)); // https://www.amazon.com/Disposable-Emergency-Breakable-Injuries-Vacation/dp/B07GJX6V7Y/ref=sr_1_4?crid=255T1HTNMHR12&keywords=instant+cold+compress&qid=1570929583&sprefix=Instat+cold+co%2Caps%2C174&sr=8-4
            add(new PackItem("Gauze Pads",72.5748,1)); // https://www.amazon.com/Sterile-Non-Adherent-dressing-absorption-sticking/dp/B005EB9SFI/ref=sr_1_11?keywords=small+gauze+pads&qid=1570929943&sr=8-11
            add(new PackItem("Thermal Blanket", 3,1)); // https://www.amazon.com/Primacare-HB-10-Emergency-Thermal-Blanket/dp/B00DZ1NFSK/ref=sr_1_4?keywords=emergency+Thermal+Blanket&qid=1570931058&sr=8-4
            add(new PackItem("Non-Latex Gloves",18.1437,1)); // https://www.amazon.com/Kimberly-Clark-Safety-55092-Nitrile/dp/B00U8TUVRA/ref=sr_1_34?keywords=non+latex+gloves&qid=1570930856&sr=8-34
            add(new PackItem("Pain Killer",1.502525,1)); // https://www.amazon.com/Advil-Capsules-Individually-Ibuprofen-Temporary/dp/B0006SW71G/ref=sr_1_1_sspa?keywords=pain%2Bkillers&qid=1570931090&sr=8-1-spons&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzT1lJUFVPSk9FMFhCJmVuY3J5cHRlZElkPUEwOTI3NjQwM0RaU1JZSEoxTTI1MCZlbmNyeXB0ZWRBZElkPUEwMDY1MDM5MUUyMUo1R0tISlVSRSZ3aWRnZXROYW1lPXNwX2F0ZiZhY3Rpb249Y2xpY2tSZWRpcmVjdCZkb05vdExvZ0NsaWNrPXRydWU&th=1
            add(new PackItem("Instructions Manual",25,0)); //
        }
    };

    // Creating MedPack 0
    private final static ArrayList<PackItem> pack0Items = new ArrayList<PackItem>(){
        {
            add(new PackItem("Narcom", 181.437,140)); // https://www.amazon.com/Rescue-Professional-Naloxone-Narcan-Overdose/dp/B072FRZJRB/ref=sr_1_1?keywords=narcon&qid=1570930123&sr=8-1 + https://time.com/5229870/naloxone-surgeon-general-cost-where-buy/
            add(new PackItem("AED", 2267.96, 1298)); // https://www.amazon.com/Philips-HeartStart-Home-Defibrillator-Carry/dp/B00064CED6/ref=sr_1_5?keywords=AED&qid=1570931296&sr=8-5
            add(new PackItem("EpiPen",100,650)); // https://www.drugs.com/article/epipen-cost-alternatives.html +
            add(new PackItem("Inhaler", 100,380)); // https://www.goodrx.com/blog/heres-why-asthma-inhalers-are-so-expensive/ +
            add(new PackItem("CPR Mask",141.748,9)); // https://www.amazon.com/CPR-Mask-Bonus-keychain-One-Way/dp/B074BH9MRJ/ref=sr_1_3?keywords=cpr+mask&qid=1570931692&sr=8-3
        }
    };



    // Default Constructor of Medpacks
    public MedPack()
    {
        packageNum = 0;
        contents.addAll(pack0Items);
        contents.addAll(pack1Items);
    }

    // Constructor of Medpacks with Package Number
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

    // Get the Medpack Package Number
    public int getPackageNum() {
        return packageNum;
    }
}
