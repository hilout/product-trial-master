import { Component, TemplateRef, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Button } from 'primeng/button';
import { DataViewModule } from 'primeng/dataview';
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { MatDialog, MatDialogActions, MatDialogClose, MatDialogContent } from '@angular/material/dialog';
import { DialogModule } from 'primeng/dialog';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule,
    Button,
    DataViewModule,
    CardModule,
    InputTextModule,
    InputTextareaModule,
    DialogModule,
    MatButton,
    MatDialogActions,
    MatDialogClose,
    MatDialogContent
  ],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {
  // @ts-ignore
  @ViewChild('myDialog', { static: true }) myDialog: TemplateRef<any>;
  formGroup: FormGroup = new FormGroup({
    email: new FormControl('', Validators.compose([Validators.required, Validators.email])),
    message: new FormControl('', Validators.compose([Validators.required]))
  });

  constructor(private dialog: MatDialog) {
  }



  submit() {
    this.formGroup.valid ? console.log('Form is valid') : console.log('Form is invalid');
    this.dialog.open(this.myDialog);
  }

}
