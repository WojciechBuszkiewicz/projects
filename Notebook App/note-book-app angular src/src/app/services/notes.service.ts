import { Note } from './../notebooks/model/note';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NotesService {
  private url = "http://localhost:8080/api/notes";

  constructor(private http: HttpClient) { }

  addNote(id: number) {
    let newNote: Note = { title: "Title", text: "Text", notebookID: id };
    return this.http.post(this.url + `/${id} `, newNote);
  }

  findNotes(id: number) {
    return this.http.get(this.url + `/${id}`);
  }

  updateNote(note: Note) {
    return this.http.put(this.url + `/${note.id}`, note);
  }

  deleteNote(id: number) {
    return this.http.delete(this.url + `/${id}`)
  }

}
