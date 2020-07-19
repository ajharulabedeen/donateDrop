import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../auth/auth.service';
import {Basic} from '../profile/basic/basic.model';
import {Post} from './post.model';
import {PostSearch} from './post-search.model';

@Injectable({
  providedIn: 'root'
})
export class PostServiceService {

  constructor(private http: HttpClient,
              private authService: AuthService) {
  }

  loading: boolean;

  save(post: Post) {
    return this.http.post(
      'http://127.0.0.1:8080/public/user/post/save', post, this.authService.getHeader()
    );
    //   .subscribe((res: Response) => {
    //   console.log(res);
    //   this.loading = false;
    // });
  } // create

  public getAllPostsByAnUser(postSearch: PostSearch) {
    return this.http.post(
      'http://localhost:8080/public/user/post/getAllPostsByAnUser', postSearch, this.authService.getHeader()
    );
  }


  countAllPostsByAnUser(postSearch: PostSearch) {
    return this.http.post(
      'http://localhost:8080/public/user/post/countAllPostsByAnUser', postSearch, this.authService.getHeader()
    );
  }

  getAllPostsByAnUserWithinDate(postSearch: PostSearch) {
    return this.http.post(
      'http://localhost:8080/public/user/post/getAllPostsByAnUserWithinDate', postSearch, this.authService.getHeader()
    );
  }

  countAllPostsByAnUserWithinDate(postSearch: PostSearch) {
    return this.http.post(
      'http://localhost:8080/public/user/post/countAllPostsByAnUserWithinDate', postSearch, this.authService.getHeader()
    );
  }
}
