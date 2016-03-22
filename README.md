# ppt-batch

Bulk upload tool for (kaakaa/ppt-museum)[https://github.com/kaakaa/ppt-museum].  

# Usage

### Download

Download zip file from [Release page](https://github.com/kaakaa/ppt-batch/releases "Release page") and unarchive it.

Zip file include below dirs.

```
$ROOT
  - bin
  - lib
  - uploads
```

### Preparing

Add folder including slide resources (.ppt/.pptx/.pdf) to `uploads` folder.

```
$ROOT
  - uploads
    - upload_test
      - .meta
      - test.ppt
    - upload_test2
      - .meta
      - test2.pptx
```


### Execution

On $ROOT, execute bellow command.

```
./bin/ppt-batch.bat
```
