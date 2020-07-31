import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {CKEditorModule} from '@ckeditor/ckeditor5-angular';
import {HttpClientModule} from '@angular/common/http';
import {LayoutModule} from '../layout/layout.module';
import {FormsModule} from '@angular/forms';
import {MyPostsComponent} from './my-posts/my-posts.component';
import {Post} from './post.model';
import {PostComponent} from './post.component';
import { PostDetailsComponent } from './post-details/post-details.component';



@NgModule({
  declarations: [ MyPostsComponent, PostComponent, PostDetailsComponent],
  imports: [
    CommonModule,
    LayoutModule,
    FormsModule,
    HttpClientModule,
    CKEditorModule
  ]
})
export class PostModule { }
