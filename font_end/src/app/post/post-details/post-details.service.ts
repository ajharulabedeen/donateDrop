import {Injectable} from '@angular/core';
import {AuthService} from '../../auth/auth.service';
import {HttpClient} from '@angular/common/http';
import {Post} from '../post.model';

@Injectable({
  providedIn: 'root'
})
export class PostDetailsService {

  constructor(private http: HttpClient,
              private authService: AuthService) {
  }

  public findOnePostByIDNoComment(postID: string) {
    return this.http.post<Post>('http://localhost:8080/public/user/post/findOnePostByIDNoComment?postID=' + postID, this.authService.getHeader());
  }

}
