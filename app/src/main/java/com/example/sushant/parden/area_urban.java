package com.example.sushant.parden;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class area_urban extends Activity implements AdapterView.OnItemSelectedListener{
    RelativeLayout l1;
    Button b2;
    static String CIRCLE_U,DIV_U,SUB_U;
    String[] CIRCLE = { "ANAND","BARODA","BARODA (CITY)","GODHRA","NADIAD"};
    String[] DIV = {"ANAND","ANAND CITY","BORSAD","PETLAD","BARODA","BODELI","DABHOI","JAMBUVA","LALBAUG","VISH EAST","VISH WEST" ,"DAHOD","GODHRA","HALOL","LUNAWADA","MEHMDABAD","NADIAD","NADIAD CITY"};
    String[] SUB = {"ANAND NORTH","ANAND SOUTH","Bhalej","Mogari S/O","UMRETH(R)","UMRETH(T)" ,"Anand Sardar S/dn", "Anand Shastri S/dn","VIDYANAGAR" ,"ANKLAV","BORSAD(R)","BORSAD(T)","Ras","Vasad" ,"CAMBAY(T)","KHAMBHAT (R)","PETLAD (R)","PETLAD(T)","SOJITRA","TARAPUR","UNDEL",
            "CHHANI","DESAR","KOYALI","Manjusar","Nandesar","SAVLI","WAGHODIA","BODELI","CHHOTAUDAIPUR","KWANT","NASWADI","PAVI-JETPUR","Tejgadh","CHANDOD","DABHOI (R)","DABHOI (T)","SANKHEDA","SHINOR","JAMBUVA","KARJAN-1","KARJAN-2","MOBHA","PADARA","Padra-2",
            "BRD-BARANPURA","BRD-GIDC","BRD-LALBAG","BRD-Manjalpur","BRD-TARSALI","BRD-WADI","BRD-DANDIYABAZAR","BRD-INDRAPURI","BRD-KARELIBAG","BRD-MANDVI","BRD-PANIGATE","BRD-SardarEstate","BRD-TOWER","BRD-AKOTA","BRD-ALKAPURI","BRD-FATEHGUNJ","BRD-GORVA","BRD-GOTRI","BRD-SAMA","BRD-VASNA",
            "Haldarwas","KAPADWANJ(R)",  "KAPADWANJ(T)", "Kapadwanj(West)", "Kathalal-2", "KATHLAL", "KHEDA",   "Limbasi","MEAHMEDABADD","BALASINOR-1","Balasinor-2","DAKOR","MAHUDHA", "THASRA","Chaklasi",   "NADIAD(city-east)","NADIAD(city-west)","NADIAD(R)","VASO"};
    String[] DIV_ANAND = {"ANAND","ANAND CITY","BORSAD","PETLAD"};
    String[] SUB_ANAND = { "ANAND NORTH","ANAND SOUTH","Bhalej","Mogari S/O","UMRETH(R)","UMRETH(T)"  };
    String[] SUB_ANAND_CITY={"Anand Sardar S/dn", "Anand Shastri S/dn","VIDYANAGAR"  };
    String[] SUB_BORSAD={"ANKLAV","BORSAD(R)","BORSAD(T)","Ras","Vasad" };
    String[] SUB_PETLAD={ "CAMBAY(T)","KHAMBHAT (R)","PETLAD (R)","PETLAD(T)","SOJITRA","TARAPUR","UNDEL"};
    String[] DIV_BARODA = {"BARODA","BODELI","DABHOI","JAMBUVA"};
    String[] SUB_BARODA={"CHHANI","DESAR","KOYALI","Manjusar","Nandesar","SAVLI","WAGHODIA"};
    String[] SUB_BODELI={"BODELI","CHHOTAUDAIPUR","KWANT","NASWADI","PAVI-JETPUR","Tejgadh"};
    String[] SUB_DABHOI={"CHANDOD","DABHOI (R)","DABHOI (T)","SANKHEDA","SHINOR"};
    String[] SUB_JAMBUVA={"JAMBUVA","KARJAN-1","KARJAN-2","MOBHA","PADARA","Padra-2"};
    String[] DIV_BARODA_CITY = {"LALBAUG","VISH EAST","VISH WEST"};
    String[] SUB_LALBAUG={"BRD-BARANPURA","BRD-GIDC","BRD-LALBAG","BRD-Manjalpur","BRD-TARSALI","BRD-WADI"};
    String[] SUB_VISH_EAST={"BRD-DANDIYABAZAR","BRD-INDRAPURI","BRD-KARELIBAG","BRD-MANDVI","BRD-PANIGATE","BRD-SardarEstate","BRD-TOWER"};
    String[] SUB_VISH_WEST={"BRD-AKOTA","BRD-ALKAPURI","BRD-FATEHGUNJ","BRD-GORVA","BRD-GOTRI","BRD-SAMA","BRD-VASNA"};
    String[] DIV_GODHRA = {"DAHOD","GODHRA","HALOL","LUNAWADA"};
    String[] SUB_DAHOD={"DAHOD (R)","DAHOD(T)","DEVGADH BARIA","Dhanpur","Fatepura","Garbada","Limdi(MG)","LIMKHEDA","ZALOD" };
    String[] SUB_GODHRA={"GODHRA (R)","GODHRA CITY EAST","GODHRA CITY WEST","Kankanpur (Timba)","SAHERA","SANTROAD"};
    String[] SUB_HALOL={"Ghoghamba","HALOL (R)","HALOL (T)","Halol-GIDC","JAMBUGHODA","KALOL","Vejalpur"};
    String[] SUB_LUNAWADA={"kadana","Kothamba","LUNAWADA II","LUNAWADA-1","SANTRAMPUR-1","SANTRAMPUR-2","Virpur"
    };
    String[] DIV_NADIAD = {"MEHMDABAD","NADIAD","NADIAD CITY"};
    String[] SUB_MEHMDABAD={"Haldarwas","KAPADWANJ(R)",  "KAPADWANJ(T)", "Kapadwanj(West)", "Kathalal-2", "KATHLAL", "KHEDA",   "Limbasi","MEAHMEDABADD"   };
    String[] SUB_NADIDAD={"BALASINOR-1","Balasinor-2","DAKOR","MAHUDHA", "THASRA"   };
    String[] SUB_NADIDAD_CITY={"Chaklasi",   "NADIAD(city-east)","NADIAD(city-west)","NADIAD(R)","VASO"};
    Spinner spin0,spin1,spin2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_urban);

        spin0 = (Spinner) findViewById(R.id.spinner1);
        spin0.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter <String> c = new ArrayAdapter <String> (this,android.R.layout.simple_spinner_item,CIRCLE);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin0.setAdapter(c);

        spin1 = (Spinner) findViewById(R.id.spinner2);
        spin1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter <String> c1 = new ArrayAdapter <String> (this,android.R.layout.simple_spinner_item,DIV);
        c1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(c1);
        //spin1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        // spin1.setEnabled(false);
        spin2 = (Spinner) findViewById(R.id.spinner3);
        spin2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter <String> c2 = new ArrayAdapter <String> (this,android.R.layout.simple_spinner_item,SUB);
        c2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(c2);
        // spin2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //spin2.setEnabled(false);

    }
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {


        String sp0 = null, sp1 = null, sp2 = null;
        sp0 = (String) spin0.getSelectedItem();
        sp1 = (String) spin1.getSelectedItem();
        sp2 = (String) spin2.getSelectedItem();
        if (arg0.equals(spin0)) {
            switch (sp0) {
                case "ANAND":

                    ArrayAdapter<String> s1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DIV_ANAND);
                    s1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin1.setAdapter(s1);


                    break;
                case "BARODA":
                    spin1.setEnabled(true);
                    ArrayAdapter<String> s2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DIV_BARODA);
                    s2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin1.setAdapter(s2);

                    break;
                case "BARODA (CITY)":
                    spin1.setEnabled(true);
                    ArrayAdapter<String> s3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DIV_BARODA_CITY);
                    s3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin1.setAdapter(s3);
                    break;
                case "GODHRA":
                    spin1.setEnabled(true);
                    ArrayAdapter<String> s4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DIV_GODHRA);
                    s4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin1.setAdapter(s4);
                    break;
                case "NADIAD":
                    spin1.setEnabled(true);
                    ArrayAdapter<String> s5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, DIV_NADIAD);
                    s5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin1.setAdapter(s5);
                    break;
                default:
            }
        }

        if (arg0.equals(spin1)) {
            switch (sp1) {

                case "ANAND":

                    ArrayAdapter<String> s2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_ANAND);
                    s2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s2);
                    break;
                case "ANAND CITY":

                    ArrayAdapter<String> s3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_ANAND_CITY);
                    s3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s3);
                    break;
                case "BORSAD":
                    ArrayAdapter<String> s4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_BORSAD);
                    s4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s4);
                    Toast.makeText(this, (CharSequence) spin2.getSelectedItem(), Toast.LENGTH_SHORT).show();
                    break;
                case "PETLAD":
                    ArrayAdapter<String> s5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_PETLAD);
                    s5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s5);
                    break;
                case "BARODA":

                    ArrayAdapter<String> s6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_BORSAD);
                    s6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s6);
                    break;
                case "BODELI":

                    ArrayAdapter<String> s7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_BODELI);
                    s7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s7);
                    break;
                case "DABHOI":
                    ArrayAdapter<String> s8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_DABHOI);
                    s8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s8);
                    Toast.makeText(this, (CharSequence) spin2.getSelectedItem(), Toast.LENGTH_SHORT).show();
                    break;
                case "JAMBUVA":
                    ArrayAdapter<String> s9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_JAMBUVA);
                    s9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s9);
                    break;
                case "LALBAUG":

                    ArrayAdapter<String> s10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_LALBAUG);
                    s10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s10);
                    break;
                case "VISH EAST":
                    ArrayAdapter<String> s11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_VISH_EAST);
                    s11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s11);
                    Toast.makeText(this, (CharSequence) spin2.getSelectedItem(), Toast.LENGTH_SHORT).show();
                    break;
                case "VISH WEST":
                    ArrayAdapter<String> s12 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_VISH_WEST);
                    s12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s12);
                    break;
                case "DAHOD":
                    ArrayAdapter<String> s13 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_DAHOD);
                    s13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s13);
                    break;
                case "GODHRA":

                    ArrayAdapter<String> s14 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_GODHRA);
                    s14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s14);
                    break;
                case "HALOL":
                    ArrayAdapter<String> s15 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_HALOL);
                    s15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s15);
                    Toast.makeText(this, (CharSequence) spin2.getSelectedItem(), Toast.LENGTH_SHORT).show();
                    break;
                case "LUNAWADA":
                    ArrayAdapter<String> s16 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_LUNAWADA);
                    s16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s16);
                    break;
                case "MEHMDABAD":
                    ArrayAdapter<String> s17 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_MEHMDABAD);
                    s17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s17);
                    break;
                case "NADIAD":

                    ArrayAdapter<String> s18 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_NADIDAD);
                    s18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s18);
                    break;
                case "NADIAD CITY":
                    ArrayAdapter<String> s19 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SUB_NADIDAD_CITY);
                    s19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(s19);
                    Toast.makeText(this, (CharSequence) spin2.getSelectedItem(), Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
        }
        CIRCLE_U= (String) spin0.getSelectedItem();
        DIV_U= (String) spin1.getSelectedItem();
        SUB_U= (String) spin2.getSelectedItem();
        b2=findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(area_urban.this,menu.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
