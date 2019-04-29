package OTE;

import java.util.HashMap;

/**
 * A class with variable and functions to make it eaisier to create programs.
 */
class Tools
{
    private static final HashMap<String, Double> NOTEFREQ = new HashMap<String, Double>() {{
        put("C-1", 8.1757989156);
        put("Db-1", 8.6619572180);
        put("D-1", 9.1770239974);
        put("Eb-1", 9.7227182413);
        put("E-1", 10.3008611535);
        put("F-1", 10.9133822323);
        put("Gb-1", 11.5623257097);
        put("G-1", 12.2498573744);
        put("Ab-1", 12.9782717994);
        put("A-1", 13.7500000000);
        put("Bb-1", 14.5676175474);
        put("B-1", 15.4338531643);

        put("C0", 16.3515978313);
        put("Db0", 17.3239144361);
        put("D0", 18.3540479948);
        put("Eb0", 19.4454364826);
        put("E0", 20.6017223071);
        put("F0", 21.8267644646);
        put("Gb0", 23.1246514195);
        put("G0", 24.4997147489);
        put("Ab0", 25.9565435987);
        put("A0", 27.5000000000);
        put("Bb0", 29.1352350949);
        put("B0", 30.8677063285);

        put("C1", 32.7031956626);
        put("Db1", 34.6478288721);
        put("D1", 36.7080959897);
        put("Eb1", 38.8908729653);
        put("E1", 41.2034446141);
        put("F1", 43.6535289291);
        put("Gb1", 46.2493028390);
        put("G1", 48.9994294977);
        put("Ab1", 51.9130871975);
        put("A1", 55.0000000000);
        put("Bb1", 58.2704701898);
        put("B1", 61.7354126570);

        put("C2", 65.4063913251);
        put("Db2", 69.2956577442);
        put("D2", 73.4161919794);
        put("Eb2", 77.7817459305);
        put("E2", 82.4068892282);
        put("F2", 87.3070578583);
        put("Gb2", 92.4986056779);
        put("G2", 97.9988589954);
        put("Ab2", 103.8261743950);
        put("A2", 110.0000000000);
        put("Bb2", 116.5409403795);
        put("B2", 123.4708253140);

        put("C3", 130.8127826503);
        put("Db3", 138.5913154884);
        put("D3", 146.8323839587);
        put("Eb3", 155.5634918610);
        put("E3", 164.8137784564);
        put("F3", 174.6141157165);
        put("Gb3", 184.9972113558);
        put("G3", 195.9977179909);
        put("Ab3", 207.6523487900);
        put("A3", 220.0000000000);
        put("Bb3", 233.0818807590);
        put("B3", 246.9416506281);

        put("C4", 261.6255653006);
        put("Db4", 277.1826309769);
        put("D4", 293.6647679174);
        put("Eb4", 311.1269837221);
        put("E4", 329.6275569129);
        put("F4", 349.2282314330);
        put("Gb4", 369.9944227116);
        put("G4", 391.9954359817);
        put("Ab4", 415.3046975799);
        put("A4", 440.0000000000);
        put("Bb4", 466.1637615181);
        put("B4", 493.8833012561);

        put("C5", 523.2511306012);
        put("Db5", 554.3652619537);
        put("D5", 587.3295358348);
        put("Eb5", 622.2539674442);
        put("E5", 659.2551138257);
        put("F5", 698.4564628660);
        put("Gb5", 739.9888454233);
        put("G5", 783.9908719635);
        put("Ab5", 830.6093951599);
        put("A5", 880.0000000000);
        put("Bb5", 932.3275230362);
        put("B5", 987.7666025122);

        put("C6", 1046.5022612024);
        put("Db6", 1108.7305239075);
        put("D6", 1174.6590716696);
        put("Eb6", 1244.5079348883);
        put("E6", 1318.5102276515);
        put("F6", 1396.9129257320);
        put("Gb6", 1479.9776908465);
        put("G6", 1567.9817439270);
        put("Ab6", 1661.2187903198);
        put("A6", 1760.0000000000);
        put("Bb6", 1864.6550460724);
        put("B6", 1975.5332050245);

        put("C7", 2093.0045224048);
        put("Db7", 2217.4610478150);
        put("D7", 2349.3181433393);
        put("Eb7", 2489.0158697766);
        put("E7", 2637.0204553030);
        put("F7", 2793.8258514640);
        put("Gb7", 2959.9553816931);
        put("G7", 3135.9634878540);
        put("Ab7", 3322.4375806396);
        put("A7", 3520.0000000000);
        put("Bb7", 3729.3100921447);
        put("B7", 3951.0664100490);

        put("C8", 4186.0090448096);
        put("Db8", 4434.9220956300);
        put("D8", 4698.6362866785);
        put("Eb8", 4978.0317395533);
        put("E8", 5274.0409106059);
        put("F8", 5587.6517029281);
        put("Gb8", 5919.9107633862);
        put("G8", 6271.9269757080);
        put("Ab8", 6644.8751612791);
        put("A8", 7040.0000000000);
        put("Bb8", 7458.6201842894);
        put("B8", 7902.1328200980);

        put("C9", 8372.0180896192);
        put("Db9", 8869.8441912599);
        put("D9", 9397.2725733570);
        put("Eb9", 9956.0634791066);
        put("E9", 10548.0818212118);
        put("F9", 11175.3034058561);
        put("Gb9", 11839.8215267723);
        put("G9", 12543.8539514160);
    }};

    private static final HashMap<Integer, String> MIDINOTE = new HashMap<Integer, String>() {{
        put(0,"C-1");
        put(1,"Db-1");
        put(2,"D-1");
        put(3,"Eb-1");
        put(4,"E-1");
        put(5,"F-1");
        put(6,"Gb-1");
        put(7,"G-1");
        put(8,"Ab-1");
        put(9,"A-1");
        put(10,"Bb-1");
        put(11,"B-1");

        put(12,"C0");
        put(13,"Db0");
        put(14,"D0");
        put(15,"Eb0");
        put(16,"E0");
        put(17,"F0");
        put(18,"Gb0");
        put(19,"G0");
        put(20,"Ab0");
        put(21,"A0");
        put(22,"Bb0");
        put(23,"B0");

        put(24,"C1");
        put(25,"Db1");
        put(26,"D1");
        put(27,"Eb1");
        put(28,"E1");
        put(29,"F1");
        put(30,"Gb1");
        put(31,"G1");
        put(32,"Ab1");
        put(33,"A1");
        put(34,"Bb1");
        put(35,"B1");

        put(36,"C2");
        put(37,"Db2");
        put(38,"D2");
        put(39,"Eb2");
        put(40,"E2");
        put(41,"F2");
        put(42,"Gb2");
        put(43,"G2");
        put(44,"Ab2");
        put(45,"A2");
        put(46,"Bb2");
        put(47,"B2");

        put(48,"C3");
        put(49,"Db3");
        put(50,"D3");
        put(51,"Eb3");
        put(52,"E3");
        put(53,"F3");
        put(54,"Gb3");
        put(55,"G3");
        put(56,"Ab3");
        put(57,"A3");
        put(58,"Bb3");
        put(59,"B3");

        put(60,"C4");
        put(61,"Db4");
        put(62,"D4");
        put(63,"Eb4");
        put(64,"E4");
        put(65,"F4");
        put(66,"Gb4");
        put(67,"G4");
        put(68,"Ab4");
        put(69,"A4");
        put(70,"Bb4");
        put(71,"B4");

        put(72,"C5");
        put(73,"Db5");
        put(74,"D5");
        put(75,"Eb5");
        put(76,"E5");
        put(77,"F5");
        put(78,"Gb5");
        put(79,"G5");
        put(80,"Ab5");
        put(81,"A5");
        put(82,"Bb5");
        put(83,"B5");

        put(84,"C6");
        put(85,"Db6");
        put(86,"D6");
        put(87,"Eb6");
        put(88,"E6");
        put(89,"F6");
        put(90,"Gb6");
        put(91,"G6");
        put(92,"Ab6");
        put(93,"A6");
        put(94,"Bb6");
        put(95,"B6");

        put(96,"C7");
        put(97,"Db7");
        put(98,"D7");
        put(99,"Eb7");
        put(100,"E7");
        put(101,"F7");
        put(102,"Gb7");
        put(103,"G7");
        put(104,"Ab7");
        put(105,"A7");
        put(106,"Bb7");
        put(107,"B7");

        put(108,"C8");
        put(109,"Db8");
        put(110,"D8");
        put(111,"Eb8");
        put(112,"E8");
        put(113,"F8");
        put(114,"Gb8");
        put(115,"G8");
        put(116,"Ab8");
        put(117,"A8");
        put(118,"Bb8");
        put(119,"B8");

        put(120,"C9");
        put(121,"Db9");
        put(122,"D9");
        put(123,"Eb9");
        put(124,"E9");
        put(125,"F9");
        put(126,"Gb9");
        put(127,"G9");
    }};


    /**
     * A function to convert standard note names into their corresponding frequency.
     * @param noteName The note to be converted, ranging from C-1 to G9 and only using flats. Example notes are Gb5, C4, A7.
     * @return The corresponding frequency of the note
     * @throws Exception The given note name is recgonized
     */

    static double NotetoFrequency(String noteName) throws Exception
    {
        if (NOTEFREQ.containsKey(noteName)) {
            return NOTEFREQ.get(noteName); }
        else
        {
            throw new Exception(noteName + " is not a recgonized note name.");
        }
    }

    static String MiditoNote(Integer midiNum) throws Exception
    {
        if ((midiNum >= 0) &&(midiNum < 128))
        {
            return MIDINOTE.get(midiNum);
        }
        else
            {
                throw new Exception(midiNum + " is not a recgonized note name");
            }
    }

}
