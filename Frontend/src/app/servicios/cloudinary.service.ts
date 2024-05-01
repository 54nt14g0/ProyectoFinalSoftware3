import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CloudinaryService {
  url: string = 'https://api.cloudinary.com/v1_1/dvxbuttqb/image/upload'

  constructor(private http:HttpClient) { }

  uploadImage(image: File): Observable<any>{
    return this.http.post(this.url, image);
  }
}
