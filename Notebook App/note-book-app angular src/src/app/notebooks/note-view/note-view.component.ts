import { NotesService } from './../../services/notes.service';
import { Note } from './../model/note';
import { Component, OnInit, Input, Output, ViewEncapsulation, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-note-view',
  templateUrl: './note-view.component.html',
  styleUrls: ['./note-view.component.css']
})
export class NoteViewComponent implements OnInit {
  @Input("note") note: Note;
  @Output() deleteNoteSingal = new EventEmitter();

  constructor(private notesService: NotesService) { }

  ngOnInit() {
  }

  updateNote() {
    this.notesService.updateNote(this.note).subscribe();
  }

  deleteNote() {
    this.deleteNoteSingal.emit(this.note);
  }

}
