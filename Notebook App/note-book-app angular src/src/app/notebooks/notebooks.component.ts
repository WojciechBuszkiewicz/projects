import { NotesService } from './../services/notes.service';
import { Component, OnInit } from '@angular/core';
import { Notebook } from './model/notebook';
import { NotebooksService } from '../services/notebooks.service';
import { Note } from './model/note';

@Component({
  selector: 'app-notebooks',
  templateUrl: './notebooks.component.html',
  styleUrls: ['./notebooks.component.css']
})
export class NotebooksComponent implements OnInit {
  private notebooks: Notebook[];
  private notes: Note[];
  private currentNotebook: Notebook = null;

  constructor(private notebooksService: NotebooksService, private notesService: NotesService) { }


  ngOnInit() {
    this.notebooksService.getNotebooks().subscribe(
      (response: Notebook[]) => {
        this.notebooks = response;
      }
    );
  }

  deleteNotebook(id: number) {
    this.notebooksService.deleteNotebook(id)
      .subscribe(() => {
        let index = this.notebooks.findIndex(el => el.id === id);
        if (this.currentNotebook === null || this.currentNotebook.id === id) {
          this.currentNotebook = null;
        }
        this.notebooks.splice(index, 1);
      })
  }

  addNotebook() {
    this.notebooksService.addNotebook().subscribe(
      (response: Notebook) => {
        this.notebooks.push(response);
      });
  }

  changeNotebook(id: number, title: string) {
    this.notebooksService.updateNotebook(id, title).subscribe(
    )
  }

  selectNotebook(notebook: Notebook) {
    this.currentNotebook = notebook;
    this.notesService.findNotes(notebook.id).subscribe(
      (response: Note[]) => {
        this.notes = response;
      })
  }

  addNote() {
    if (this.currentNotebook === null) return;

    this.notesService.addNote(this.currentNotebook.id)
      .subscribe((response: Note) => {
        this.notes.push(response);
      })
  }

  deleteNote(note: Note) {
    this.notesService.deleteNote(note.id).subscribe(
      () => {
        let index = this.notes.findIndex((el: Note) => el.id === note.id)
        this.notes.splice(index, 1);
      }
    )


  }

}
