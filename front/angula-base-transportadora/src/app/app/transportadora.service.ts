import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Transportadora } from '../../model/transportadora.model';
import { from } from 'rxjs';
import { tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class TransportadoraService {

  constructor(private http: HttpClient) { }
  url = 'http://localhost:8080/v1/transportadora';

  getAll() {
    return this.http.get<Transportadora[]>(this.url, {headers: this.getHeader()} )
    .pipe(
      tap(console.log)
    );
  }

  getById(id: number) {
    return this.http.get<Transportadora>(this.url + '/' + id, {headers: this.getHeader()} ).pipe(
      tap(console.log)
    );
  }

  save(t: Transportadora) {
    return this.http.post(this.url, t, {headers: this.getHeader()} )
    .subscribe(exists => {
      console.log(exists);
    });
  }

  update(t: Transportadora) {
    return this.http.put(this.url, t, {headers: this.getHeader()} )
    .subscribe(exists => {
      console.log(exists);
    });
  }

  delete(t: Transportadora) {
    return this.http.
    delete(this.url + '/' + t.codigoTransportadora, {headers: this.getHeader()} )
    .subscribe(console.log);
  }

  getHeader() {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa('admin' + ':' + 'admin') });
    return headers;
  }
}
