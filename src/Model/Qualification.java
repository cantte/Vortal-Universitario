/*
 * Copyright (C) 2019 Carlos Pavajeau
 * 
 */

package Model;

import java.io.Serializable;

/**
 * This is the class {@code Qualification}. Represents a 3-grade grade assigned
 * to a {@code Subject}, this class is used by the {@code Student}s 
 * to keep track of the grades they receive.
 * 
 * @version 1.0
 * @author Carlos Pavajeau - Cantte
 */
public class Qualification implements Comparable<Qualification>, Serializable
{
    private static final long serialVersionUID = -3976167163648817646L;
    
    private static final int ACADEMICS_CORTS = 3;
    private static final int NOTE_EMPTY = -1;

    private Subject subject;
    private float[] notes;

    /**
     * Initialize a new {@code Qualification} with these characteristics.
     * @param subject that is to be assigned to the object.
     */
    public Qualification(Subject subject)
    {
        this(subject, new float[]{NOTE_EMPTY, NOTE_EMPTY, NOTE_EMPTY});
    }

    /**
     * Initialize a new {@code Qualification} with these characteristics.
     * @param _subject that is to be assigned to the object.
     * @param _notes it will be the notes that this {@code Qualification} has.
     */
    public Qualification(Subject _subject, float[] _notes)
    {
        subject = _subject;
        notes = _notes;
    }

    /**
     * This method returns the subject that this {@code Qualification} has. 
     * @return the subject that this {@code Qualification} has.
     */
    public Subject GetSubject()
    {
        return subject;
    }

    /**
     * This method returns the notes that this {@code Qualification} has. 
     * @return the notes that this {@code Qualification} has.
     */
    public float[] GetNotes()
    {
        return notes;
    }

    /**
     * This method returns one note that this {@code Qualification} has.
     * @param cort is a academic cut 
     * @return one note that this {@code Qualification} has.
     */
    public float GetNote(int cort)
    {
        return notes[cort];
    }

    /**
     * This method add a new note for this {@code Qualification}
     * @param academicCut It will be the academic cut evaluated
     * @param note It will be the note of that academic cut.
     */
    public void AddNote(int academicCut, float note)
    {
        notes[academicCut] = note;
    }

    /**
     * This method does the action of validate that this object {@code Qualification} not has one note.
     * @return {@code true} if this object {@code Qualification} has one note. {@code false} otherwise.
     */
    public boolean HasNotes()
    {
        for (float note : notes)
            if (!IsNoteEmpty(note))
                return true;
        return false;
    }

    /**
     * This method return the current average that have this {@code Qualification}.
     * @return the current average of this {@code Qualification}.
     */
    public float GetAverage()
    {
        float average = 0.0f;
        for (int i = 0; i < ACADEMICS_CORTS; i++)
        {
            if (!IsNoteEmpty(notes[i]))
            {
                if (i < ACADEMICS_CORTS - 1)/**First or second academic cut*/
                    average += notes[i] * 0.3; /**30% */
                else /**Third academic cut */
                    average += notes[i] * 0.4; /**40% */
            }
        }

        return average;
    }

    /**
     * This method validate if this note is not empty.
     * @param note to validate.
     * @return {@code true} if note == {@code NOTE_EMPTY}. {@code false} otherwise.
     */
    private boolean IsNoteEmpty(float note)
    {
        return note == NOTE_EMPTY;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Qualification other = (Qualification) obj;
        if (GetSubject() == null) {
            if (other.GetSubject() != null)
                return false;
        } else if (!GetSubject().equals(other.GetSubject()))
            return false;
        return true;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((GetSubject() == null) ? 0 : GetSubject().hashCode());
        return result;
    }

    @Override
    public int compareTo(Qualification o) 
    {
        return GetSubject().compareTo(o.GetSubject());
    }
}