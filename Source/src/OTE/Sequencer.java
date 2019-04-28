package OTE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sequencer {
    //List of frequencies that will be played
    ArrayList<String> noteList;

    boolean DEBUG = false;

    //Time to wait before playing the next note. time is in miliseconds
    long delayTime;

    //Instrument that is being used for the Sequencer
    OvertoneInstrument instrument;

    boolean playing = false;

    //Next note to be played by the sequencer
    int nextNote = 0;

    ScheduledExecutorService timeLine;

    Callable<Void> calledSequencer;

    public Sequencer(OvertoneInstrument inInstrument, long initDelay, boolean debugmode) {
        //Decide the debug mode
        DEBUG = debugmode;

        //Set the sequencer's instrument that is being used
        instrument = inInstrument;
        dmsg("Successfully initialized instrument to be used");


        //Set the delay for the sequencer
        delayTime = initDelay;
        dmsg("Successfully initialized delay to " + delayTime);

        dmsg("Successfully initialized Sequencer list. Current size: " + noteList.size());

        noteList = new ArrayList<>();

        calledSequencer = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                try {
                    //This occurs at every regular period as specified.
                    //Pull the next note to be played and play it
                    if (nextNote >= noteList.size()) {
                        nextNote = 0;
                    }

                    //instrument.adjustFrequency(freqList.get(nextNote));
                    instrument.adjustFrequency(Tools.NOTEFREQ.get(noteList.get(nextNote)));
                    dmsg("Adjusted instrument to play frequency " + noteList.get(nextNote) + " at sequencer position " + nextNote);

                    //Now that its being played, then increment the next note
                    nextNote += 1;
//                    if (nextNote >= freqList.size()) {
                    if (nextNote >= noteList.size()) {
                        //Reset the sequencer at position 0 if it reaches the end.
                        nextNote = 0;
                    }
                    dmsg("Set the sequencer (size " + noteList.size() + ") position to " + nextNote);
                } finally {
                    //Reschedule the new method so that it can be done dynamically
                    timeLine.schedule(this, delayTime, TimeUnit.MILLISECONDS);
                    dmsg("Scheduled next event to occur in " + delayTime + " milliseconds");
                }
                return null;
            }
        };

    }


    public void changeInstrument(OvertoneInstrument newInstrument) {
        //Stop the sequencer if it's currently playing

        if (playing)
        {
            timeLine.shutdownNow();
            dmsg("Cancelled all scheduled event in preperation for instrument switch");
            instrument.stopGeneratingSound();
            dmsg("Stopped old instrument from playing");
        }

        //Now that it has stopped, swap things out
        instrument = newInstrument;
        dmsg("Swapped instruments successfully!");

        //If it was playing, then restart the sequencer
        if (playing)
        {
            instrument.generateSound();
            dmsg("Commanded new instrument to generate sound");
            timeLine.schedule(calledSequencer, delayTime, TimeUnit.MILLISECONDS);
            dmsg("Scheduled the next sequencer event");
        }
    }

    public void adjustDelay(long newDelay) {
        delayTime = newDelay;
        dmsg("Adjusted the delay to " + delayTime);
    }


    public void addNote(String newnote)
    {
        noteList.add(newnote);
    }

    //Debug method for buiding the sequencer listing in a linear fashion
    private String linearSequencerList()
    {
        String vals = String.format("Sequencer of Size %d",noteList.size());
        int dex = 0;
        for (String seq : noteList)
        {
            vals = String.format("%s P%d: %s ",vals,dex,seq);
            dex += 1;
        }
        return vals;
    }

    private int getOctave(String note)
    {
        String octStr = note.substring(1);
        int oct = Integer.valueOf(octStr);

        return oct;
    }

    public void adjustOctaveUp()
    {
        boolean valid = true;
        ArrayList<String> adj = new ArrayList<>();
        for (String note : noteList)
        {
            //For each string, find out the octave first.
            int oct = getOctave(note);
            if (oct < 9)
            {
                adj.add(String.format("%s%d",note.charAt(0),oct + 1));
            }
            else
            {
                valid = false;
                break;
            }
        }
        if (valid)
            noteList = adj;
    }



    public void adjustOctaveDown()
    {
        boolean valid = true;
        ArrayList<String> adj = new ArrayList<>();
        for (String note:noteList)
        {
            //For each string, find out the octave first.
            int oct = getOctave(note);
            if (oct > -1)
            {
                adj.add(String.format("%s%d",note.charAt(0),oct - 1));
            }
            else
            {
                valid = false;
                break;
            }
        }

        if (valid)
        {
            noteList = adj;
        }
    }

    //Add note at a specific position
    public void addNote(String newNote, int position)
    {
        dmsg("Adding a note at position " + position);
        dmsg("Prelisting " + linearSequencerList());

        if ((position <= noteList.size()) && (position > -1))
        {
            //The position is valid, so go ahead and remove the note
            noteList.add(position,newNote);
            dmsg("Postlister " + linearSequencerList());
        }
        else
        {
            throw new IndexOutOfBoundsException("Given position " + position + " is out of bounds for sequencer list of size "+ noteList.size());
        }


    }


    //remove frequency to the end of the sequence
    public void removeLastNote() throws Exception {
        if (noteList.size() > 0) {
            dmsg("Removing last note from " + linearSequencerList());
            noteList.remove((noteList.size() - 1));
            dmsg("Current sequencer: " + linearSequencerList());
        } else {
            throw new EmptyListException("Sequencer list is empty");
        }
    }


    //Remove frequency from the beginning of the sequence
    public void removeFirstNote() throws Exception {
        if (noteList.size() > 0) {
            dmsg("Removing the first note of sequencer");
            dmsg("Prelist: " + linearSequencerList());
            noteList.remove(0);
            dmsg("Postlst: " + linearSequencerList());
        } else {
            throw new EmptyListException("Sequencer list is empty");
        }
    }

    //Remove note at a specific position
    public void removeNote(int position) throws Exception
    {
        if (!(noteList.size() > 0))
        {
            throw new EmptyListException("Sequencer list is empty");
        }
        else
        {
            if (position < noteList.size())
            {
                //The position is valid, so go ahead and remove the note
                noteList.remove(position);
            }
            else
            {
                throw new IndexOutOfBoundsException("Given position " + position + " is out of bounds for sequencer list of size "+ noteList.size());
            }
        }

    }


    public void startSequencer() {
        timeLine = Executors.newSingleThreadScheduledExecutor();
        playing = true;
        instrument.generateSound();
        timeLine.schedule(calledSequencer, delayTime, TimeUnit.MILLISECONDS);

    }

    public void stopSequencer() {
        playing = false;
        timeLine.shutdownNow();
        instrument.stopGeneratingSound();
    }

    public void enableDebug()
    {
        DEBUG = true;
        System.out.println("Debug Mode has been enabled. Use disableDebug to turn it off and stop verbose messages.");
    }

    public void disableDebug()
    {
        DEBUG = false;
    }

    public void dmsg(String message)
    {
        if (DEBUG)
        {
            System.out.println(message);
        }
    }

}



    class EmptyListException extends Exception {
        public EmptyListException(String message) {
            super(message);
        }

        public EmptyListException(Throwable cause) {
            super(cause);
        }

        public EmptyListException(String message, Throwable cause) {
            super(message, cause);
        }
    }
