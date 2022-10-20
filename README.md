# JavaInteractive

### Tasks
* [IntSorter](src/main/java/dev/oxeg/intsorter)
* [FileSeparator](src/main/java/dev/oxeg/fileseparator)

### Preparation
* fork this project into your GitHub account
* clone your forked project with `git clone` on your local machine
* add a remote reference to this project
```shell
git remote add oxeg git@github.com:oxeg/JavaInteractive.git
```
* you can check your remote references with `git remote -v`, it should show something like
```shell
> git remote -v                                              
origin  git@github.com:{your account name}/JavaInteractive.git (fetch)
origin  git@github.com:{your account name}/JavaInteractive.git (push)
oxeg    git@github.com:oxeg/JavaInteractive.git (fetch)
oxeg    git@github.com:oxeg/JavaInteractive.git (push)

```
* open the project in any IDE of your choice (remember to add IDE-specific files and folders to `.gitignore`)

### Participation
When a new task is published, to submit your solution do next
* update the project by switching to the `main` branch and pulling latest changes from `oxeg` repo
```shell
git switch main
git pull oxeg main
git push origin main
```
* create a branch with name indicating the task and your name(i.e. `int_sorter_{your account name}`)
```shell
git checkout -b int_sorter_johndoe
```
* in the task package create your subpackage (i.e. `dev.oxeg.intsorter.johndoe`)
* write your implementation
  * write implementation class in the subpackage you created
  * add `final` field to the banchmark class
  * add a method that runs your implementation annotated with `@Benchmark`
  * use `Blackhole bh` method parameter and `bh.consume(...)` to prevent dead code elimination
  * add new `@Test` method to the testcase for this task to make sure your solution is correct
* commit and push the changes to your repository using the branch name you just created
```shell
git add --all
git commit -m "IntSorter implementation from JohnDoe"
git push origin `int_sorter_{your account name}`
```
* create a pull request to the https://github.com/oxeg/JavaInteractive
  * in your forked project click **Pull requests**
  * click **New pull request**
  * make sure that **base repository** is `oxeg/JavaInteractive` and **base** branch is `main`
  * make sure that **head repository** is `{your account name}/JavaInteractive` and **compare** branch is the branch you created 
* once your Pull request is merged, benchmark results will be published to the current task `README.md`
