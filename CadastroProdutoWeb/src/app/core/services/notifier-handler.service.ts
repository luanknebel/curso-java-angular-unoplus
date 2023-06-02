import { Injectable } from '@angular/core';
import { NotifierService } from 'angular-notifier';

@Injectable({
  providedIn: 'root'
})
export class NotifierHandlerService {

  private readonly SUCESS = 'success';
  private readonly WARNING = 'warning';
  private readonly ERROR = 'error';
  private readonly INFO = 'info';
  private readonly DEFAULT = 'default';
  private readonly notifierService: NotifierService;

  constructor(notifierService: NotifierService) {
    this.notifierService = notifierService;
  }

  notifySucess(message : any){
    this.notifierService.notify(this.SUCESS, String(message));
  }

  notifyWarning(message : any){
    this.notifierService.notify(this.WARNING, String(message));
  }

  notifyError(message : any){
    this.notifierService.notify(this.ERROR, String(message));
  }

  notifyInfo(message : any){
    this.notifierService.notify(this.INFO, String(message));
  }

  notify(message : any){
    this.notifierService.notify(this.DEFAULT, String(message));
  }
  
}

