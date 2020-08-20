import {Injectable} from '@angular/core';
import {AuthService} from '../../auth/auth.service';
import {HttpClient} from '@angular/common/http';
import {Post} from '../post.model';
import {PostcommentWithUserInfo} from './postcomment-with-user-info.model';
import {CommentSave} from './comment-save.model';

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

  public getCommentWithUserInfo(postID: string) {
    return this.http.post<PostcommentWithUserInfo[]>('http://localhost:8080/public/user/post/getCommentWithUserInfo?postID=' + postID, this.authService.getHeader());
  }

  saveComment(commentSave: CommentSave) {
    return this.http.post<any>('http://localhost:8080/public/user/post/saveComment', commentSave, this.authService.getHeader());
  }
}
