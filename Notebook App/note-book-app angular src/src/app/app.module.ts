import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { NotebooksService } from './services/notebooks.service';
import { NotesService } from './services/notes.service';
import { NotebooksComponent } from './notebooks/notebooks.component';
import { NoteViewComponent } from './notebooks/note-view/note-view.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    NotebooksComponent,
    NoteViewComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [
    NotebooksService,
    NotesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
