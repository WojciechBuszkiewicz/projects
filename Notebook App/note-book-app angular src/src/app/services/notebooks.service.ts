import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Notebook } from '../notebooks/model/notebook';

@Injectable({
  providedIn: 'root'
})
export class NotebooksService {
  private url = "http://localhost:8080/api/noteBooks";


  constructor(private http: HttpClient) {
  }

  getNotebooks() {
    return this.http.get<Notebook[]>(this.url + '/all');
  }

  addNotebook() {
    let notebook = { title: "Default" };
    return this.http.post(this.url, notebook);
  }

  deleteNotebook(id: number) {
    return this.http.delete(this.url + `/${id}`);
  }

  updateNotebook(id: number, title: string) {
    return this.http.put(this.url + `/${id}`, { title: title });
  }

}
